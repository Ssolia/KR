package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/TAXOPARK";
    private static final String USER = "root";
    private static final String PASSWORD = "26102004Solia_";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Log the error or handle it gracefully
            System.err.println("Failed to connect to the database: " + e.getMessage());
            // Re-throw the exception or throw a custom exception
            throw e;
        }
    }

}
