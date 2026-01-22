package dev.duyhvt.section_22.MySQLMusic;

import java.sql.*;

public class MusicDML {

  public static void main(String[] args) {

    try (Connection connection =
            DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/music",
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"));
        Statement statement = connection.createStatement()) {
      String tableName = "music.artists";
      String columnName = "artist_name";
      String columnValue = "Bob Dylan";
      if (!executeSelect(statement, tableName, columnName, columnValue)) {
        System.out.println("Maybe we should add this record");
        var isInserted =
            insertRecord(
                statement, tableName, new String[] {columnName}, new String[] {columnValue});
        if (isInserted) {
          System.out.println("Ye, we inserted the record");
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static boolean printRecord(ResultSet resultSet) throws SQLException {
    boolean foundData = false;
    var meta = resultSet.getMetaData();

    System.out.println("=======================");

    for (int i = 1; i <= meta.getColumnCount(); i++) {
      System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
    }
    System.out.println();
    while (resultSet.next()) {
      for (int i = 1; i <= meta.getColumnCount(); i++) {
        System.out.printf("%-15s", resultSet.getString(i));
      }
      System.out.println();
      foundData = true;
    }

    return foundData;
  }

  private static boolean executeSelect(
      Statement statement, String table, String columnName, String columnValue)
      throws SQLException {

    String query = "SELECT * FROM %s WHERE %s = '%s'".formatted(table, columnName, columnValue);
    var resultSet = statement.executeQuery(query);

    return resultSet != null && printRecord(resultSet);
  }

  private static boolean insertRecord(
      Statement statement, String table, String[] columnNames, String[] columnValues)
      throws SQLException {

    String colNames = String.join(", ", columnNames);
    String colValues = String.join(", ", columnValues);
    String query = "INSERT INTO %s (%s) VALUES ('%s')".formatted(table, colNames, colValues);
    System.out.println(query);

    statement.execute(query);

    int recordsInserted = statement.getUpdateCount();
    if (recordsInserted > 0) {
      executeSelect(statement, table, columnNames[0], columnValues[0]);
    }

    return recordsInserted > 0;
  }
}
