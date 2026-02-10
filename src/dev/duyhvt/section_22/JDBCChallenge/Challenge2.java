package dev.duyhvt.section_22.JDBCChallenge;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

record OrderDetails(int orderDetailId, String itemDescription, int quantity) {
  public OrderDetails(String itemDescription, int quantity) {
    this(-1, itemDescription, quantity);
  }
}

record Order(int orderId, String dateString, List<OrderDetails> details) {
  public Order(String dateString) {
    this(-1, dateString, new ArrayList<>());
  }

  public void addDetail(String itemDescription, int quantity) {
    OrderDetails item = new OrderDetails(itemDescription, quantity);
    details.add(item);
  }
}

public class Challenge2 {
  static String SCHEMA_NAME = "storefront";
  static String TABLE_NAME = "order_details";
  static String COLUMN_NAME = "quantity";

  public static void main(String[] args) {
    var dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setPort(3306);
    dataSource.setUser(System.getenv("MYSQL_USER"));
    dataSource.setPassword(System.getenv("MYSQL_PASS"));
    List<Order> orders = readData();

    try (Connection connection = dataSource.getConnection()) {
      if (!columnExists(connection, SCHEMA_NAME, TABLE_NAME, COLUMN_NAME)) {
        addNewDBColumn(connection);
      }

      addOrders(connection, orders);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean columnExists(
      Connection connection, String schemaName, String orderDetails, String quantity)
      throws SQLException {
    DatabaseMetaData metaData = connection.getMetaData();
    try (ResultSet resultSet = metaData.getColumns(schemaName, null, orderDetails, quantity)) {
      return resultSet.next();
    }
  }

  private static void addNewDBColumn(Connection connection) throws SQLException {
    String alterString = "ALTER TABLE storefront.order_details ADD COLUMN quantity INT";
    Statement statement = connection.createStatement();
    statement.execute(alterString);
  }

  private static List<Order> readData() {
    List<Order> vals = new ArrayList<>();

    try (Scanner scanner = new Scanner(Path.of("resources/Orders.csv"))) {
      scanner.useDelimiter("[,\\n]");
      var list = scanner.tokens().map(String::trim).toList();
      for (int i = 0; i < list.size(); i++) {
        String value = list.get(i);
        if (value.equals("order")) {
          var date = list.get(++i);
          vals.add(new Order(date));
        } else if (value.equals("item")) {
          var quantity = Integer.parseInt(list.get(++i));
          var description = list.get(++i);
          Order order = vals.getLast();
          order.addDetail(description, quantity);
        }
      }
      vals.forEach(System.out::println);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return vals;
  }

  private static void addOrder(
      Connection connection,
      PreparedStatement preparedStatementOrder,
      PreparedStatement preparedStatementDetail,
      Order order)
      throws SQLException {
    try {
      connection.setAutoCommit(false);
      int orderId;
      preparedStatementOrder.setString(1, order.dateString());
      if (preparedStatementOrder.executeUpdate() == 1) {
        var resultSet = preparedStatementOrder.getGeneratedKeys();
        if (resultSet.next()) {
          orderId = resultSet.getInt(1);
          System.out.println("orderId = " + orderId);

          if (orderId > -1) {
            preparedStatementDetail.setInt(1, orderId);
            for (OrderDetails detail : order.details()) {
              preparedStatementDetail.setString(2, detail.itemDescription());
              preparedStatementDetail.setInt(3, detail.quantity());
              preparedStatementDetail.addBatch();
            }
            int[] result = preparedStatementDetail.executeBatch();
            int rowsInserted = Arrays.stream(result).sum();
            if (rowsInserted != order.details().size()) {
              throw new SQLException("Inserts don't match");
            }
          }
        }
      }
      connection.commit();
      connection.setAutoCommit(true);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void addOrders(Connection connection, List<Order> orders) throws SQLException {
    String insertOrder = "INSERT INTO storefront.orders (order_date) VALUE (?)";
    String insertDetail =
        "INSERT INTO storefront.order_details (order_id, item_description, quantity) VALUES (?, ?, ?)";

    try (PreparedStatement psOrder =
            connection.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement psDetail =
            connection.prepareStatement(insertDetail, Statement.RETURN_GENERATED_KEYS)) {
      orders.forEach(
          order -> {
            try {
              addOrder(connection, psOrder, psDetail, order);
            } catch (SQLException e) {
              System.err.printf("%d (%s) %s%n", e.getErrorCode(), e.getSQLState(), e.getMessage());
              System.err.println("Problem: " + psOrder);
              System.err.println("Order: " + order);
            }
          });
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
