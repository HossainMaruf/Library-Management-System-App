package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
   private String url;
   private String username;
   private String password;
   private short connectionStatus = 0; // offline
   Connection conn = null;
   public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
   } 
   public short getConnectionStatus() {
        return connectionStatus; 
   }
   public Connection getConnection() {
        return conn;
   }
   public short connect() {
        try{
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null && !conn.isClosed()) { return connectionStatus = 1; } 
            else { return connectionStatus = 0; }
        } catch (SQLException e) {
            e.printStackTrace();
            return connectionStatus = 0;
        }
   }
}
