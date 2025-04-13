package dev.duyhvt.section_22.QueryMusic;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("src/dev/duyhvt/section_22/QueryMusic/music.properties"),
                    StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));
        try {
            dataSource.setMaxRows(10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an Artist Id: ");
//        String artistId = scanner.nextLine();
//        int artistid = Integer.parseInt(artistId);

        String query = "SELECT * FROM music.artists limit 10";
//                .formatted(artistid);

        try (var connection = dataSource.getConnection(
                props.getProperty("user"),
                System.getenv("MYSQL_PASS"));
            Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
//            for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                System.out.printf("%d %s %s%n",
//                        i,
//                        metaData.getColumnName(i),
//                        metaData.getColumnTypeName(i));
//            }

            System.out.println("=".repeat(15));
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-15s", metaData.getColumnName(i).toUpperCase());
            }
            System.out.println();
            while (resultSet.next()) {
//                System.out.printf("%d %s %s %n", resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title"));
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
