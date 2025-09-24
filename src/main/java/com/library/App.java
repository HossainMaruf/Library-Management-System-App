package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ) {
         // JDBC URL format: jdbc:mysql://host:port/database
        String url = "jdbc:mysql://localhost:3306/library";  // Change to your DB info
        String username = "root";                               // Your DB username
        String password = "";                       // Your DB password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
