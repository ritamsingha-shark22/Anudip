package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    // Private constructor to enforce Singleton pattern
    private DBConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load database configuration from properties file
                Properties props = new Properties();
                try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
                    props.load(fis);
                }

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");

                // Load the JDBC driver
                Class.forName(driver);

                // Create a connection
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Database connection established successfully.");
            } catch (IOException e) {
                System.err.println("Error reading the properties file: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.err.println("Database driver not found: " + e.getMessage());
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error establishing database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
