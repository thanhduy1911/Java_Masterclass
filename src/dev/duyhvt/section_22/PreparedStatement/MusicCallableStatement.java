package dev.duyhvt.section_22.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;
import dev.duyhvt.section_22.MySQLMusic.MusicDML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

public class MusicCallableStatement {
  private static final int ARTIST_COLUMN = 0;
  private static final int ALBUM_COLUMN = 1;
  private static final int SONG_COLUMN = 3;

  public static void main(String[] args) {
    Map<String, Map<String, String>> albums;

    try (var lines = Files.lines(Path.of("resources/NewAlbums.csv"))) {
      albums =
          lines
              .map(s -> s.split(","))
              .collect(
                  Collectors.groupingBy(
                      s -> s[ARTIST_COLUMN],
                      Collectors.groupingBy(
                          s -> s[ALBUM_COLUMN],
                          Collectors.mapping(
                              s -> s[SONG_COLUMN], Collectors.joining("\",\"", "[\"", "\"]")))));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    albums.forEach(
        (artist, artistAlbums) ->
            artistAlbums.forEach(
                (key, value) -> {
                  System.out.println("Artist: " + artist + ", Song: " + value);
                  System.out.println("DEBUG Duyhvt");
                  System.out.println(key + ": " + value);
                }));
    var datasource = new MysqlDataSource();
    datasource.setServerName("localhost");
    datasource.setPort(3306);
    datasource.setDatabaseName("music");

    try (Connection connection =
        datasource.getConnection(System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASS"))) {
      CallableStatement callableStatement = connection.prepareCall("CALL music.addAlbum(?,?,?)");
      albums.forEach(
          (artist, artistAlbums) ->
              artistAlbums.forEach(
                  (album, songs) -> {
                    try {
                      callableStatement.setString(1, artist);
                      callableStatement.setString(2, album);
                      callableStatement.setString(3, songs);
                      callableStatement.execute();
                    } catch (SQLException e) {
                      System.err.println(e.getErrorCode() + " " + e.getMessage());
                    }
                  }));

      String sql = "SELECT * FROM music.albumview WHERE artist_name = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, "Bob Dylan");
      ResultSet resultSet = ps.executeQuery();
      MusicDML.printRecord(resultSet);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
