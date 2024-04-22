package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {
    private static final String  USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/BDguanabira";

    private static final String PASSWORD = "admin";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(USER, URL, PASSWORD);
                return connection;
            } else {
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}