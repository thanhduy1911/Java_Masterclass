package dev.duyhvt.section_22.JDBCChallenge;

import com.mysql.cj.jdbc.MysqlDataSource;
import dev.duyhvt.utilities.exceptions.MySQLException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Challenge1 {
  private static final String USE_SCHEMA;
  private static final int MYSQL_DB_NOT_FOUND = 1049;

  static {
    USE_SCHEMA = "USE storefront";
  }

  public static void main(String[] args) {
    var dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setPort(3306);
    dataSource.setUser(System.getenv("MYSQL_USER"));
    dataSource.setPassword(System.getenv("MYSQL_PASS"));

    try (Connection connection = dataSource.getConnection()) {
      DatabaseMetaData metaData = connection.getMetaData();
      System.out.println(metaData.getSQLStateType());
      if (!checkSchema(connection)) {
        System.out.println("storefront schema does not exist");
        setUpSchema(connection);
      }

      //      int newOrder = addOrder(connection, new String[] {"shoes", "shirt", "socks"});
      //      System.out.println("New Order = " + newOrder);
      deleteOrder(connection, 1);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean checkSchema(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute(USE_SCHEMA);
    } catch (SQLException e) {
      System.err.println("SQLState: " + e.getSQLState());
      System.err.println("Error Code: " + e.getErrorCode());
      System.err.println("Message: " + e.getMessage());

      var productName = connection.getMetaData().getDatabaseProductName();
      if (productName.equalsIgnoreCase("MySQL") && e.getErrorCode() == MYSQL_DB_NOT_FOUND) {
        return false;
      } else throw e;
    }
    System.out.println("Schema check complete");
    return true;
  }

  private static void setUpSchema(Connection connection) throws SQLException {
    String createSchema = "CREATE SCHEMA storefront";
    String createOrder =
"""
CREATE TABLE storefront.orders (
order_id int NOT NULL AUTO_INCREMENT,
order_date DATETIME NOT NULL,
PRIMARY KEY (order_id)
)""";

    String createOrderDetails =
"""
CREATE TABLE storefront.order_details (
order_detail_id int NOT NULL AUTO_INCREMENT,
item_description text,
order_id int DEFAULT NULL,
PRIMARY KEY (order_detail_id),
KEY FK_ORDER_ID (order_id),
CONSTRAINT FK_ORDER_ID FOREIGN KEY (order_id)
REFERENCES storefront.orders (order_id) ON DELETE CASCADE)
""";

    try (Statement statement = connection.createStatement()) {
      System.out.println("Creating storefront database...");
      statement.execute(createSchema);
      if (checkSchema(connection)) {
        statement.execute(createOrder);
        System.out.println("Successfully Created Order");
        statement.execute(createOrderDetails);
        System.out.println("Successfully Created Order Details");
      }

    } catch (SQLException e) {
      System.err.println("Message: " + e.getMessage());
    }
  }

  private static int addOrder(Connection connection, String[] items) throws SQLException {
    int orderId = -1;
    String insertOrder = "INSERT INTO storefront.orders (order_date) VALUES ('%s')";
    String insertDetails =
        "INSERT INTO storefront.order_details (order_id, item_description) VALUES (%d, %s)";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String orderDateTime = LocalDateTime.now().format(dateTimeFormatter);
    System.out.println(orderDateTime);
    String formattedString = insertOrder.formatted(orderDateTime);
    System.out.println(formattedString);

    try (Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);
      int inserts = statement.executeUpdate(formattedString, Statement.RETURN_GENERATED_KEYS);
      if (inserts == 1) {
        var generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
          orderId = generatedKeys.getInt(1);
        }
      }
      int count = 0;
      for (var item : items) {
        formattedString = insertDetails.formatted(orderId, statement.enquoteLiteral(item));
        inserts = statement.executeUpdate(formattedString);
        count += inserts;
      }
      if (count != items.length) {
        orderId = -1;
        System.out.println("Number of records inserted doesn't equal to items received");
        connection.rollback();
      } else {
        connection.commit();
      }
      connection.setAutoCommit(true);
    } catch (SQLException e) {
      connection.rollback();

      throw new MySQLException(e.getMessage());
    }
    return orderId;
  }

  private static void deleteOrder(Connection connection, int orderId) throws SQLException {
    String deleteOrder = "DELETE FROM storefront.orders WHERE order_id = %d";
    String deleteQuery = deleteOrder.formatted(orderId);

    try (Statement statement = connection.createStatement()) {
      int deletedRecords = statement.executeUpdate(deleteQuery);
      System.out.printf("%d records deleted\n", deletedRecords);
    } catch (SQLException e) {
      connection.rollback();
      throw new MySQLException(e.getMessage());
    }
  }
}
