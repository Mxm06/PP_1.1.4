package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/firstdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Ardashov06";

    static private Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
