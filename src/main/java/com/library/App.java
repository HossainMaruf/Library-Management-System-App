package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main( String[] args ) {
         // JDBC URL format: jdbc:mysql://host:port/database
        String url = "jdbc:mysql://localhost:3306/library";  // Change to your DB info
        String username = "root";                               // Your DB username
        String password = "";                       // Your DB password
        Connection conn = null;
        Statement stmt = null;

        try{
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to the database successfully!");
                String sql = "select * from users";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println(id + " " + name);
                }
                rs.close();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
