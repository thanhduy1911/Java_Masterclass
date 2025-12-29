package dev.duyhvt.section_22.MySQLMusic;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/music";
    public static void main(String[] args){

        String username = JOptionPane.showInputDialog(null,"Username: ");

        JPasswordField passwordField = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, passwordField, "Password",  JOptionPane.OK_CANCEL_OPTION);
        final char[] password = (okCxl == JOptionPane.OK_OPTION) ? passwordField.getPassword() : null;

        var dataSource = new MysqlDataSource();
        dataSource.setURL(CONNECTION_STRING);
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");
        dataSource.setUser(username);
        assert password != null;
        dataSource.setPassword(String.valueOf(password));

        // try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, username, String.valueOf(password))) {
        try (Connection connection = dataSource.getConnection()) {
          System.out.println("Successfully connected to database.");
          Arrays.fill(password, ' ');
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
