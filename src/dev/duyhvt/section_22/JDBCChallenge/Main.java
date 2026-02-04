package dev.duyhvt.section_22.JDBCChallenge;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
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
}
