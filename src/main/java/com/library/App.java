package com.library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.db.Database;
import com.model.User;

public class App {
    public static void main( String[] args ) throws Exception{
        String url = "jdbc:mysql://localhost:3306/library";  // Change to your DB info
        String username = "root";                               // Your DB username
        String password = "";                       // Your DB password
        Database db = new Database(url, username, password);
        db.connect(); // try to connect
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        User user = new User(stmt);
        user.getAll();
        ResultSet rs = stmt.executeQuery("select * from users");
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + " " + name);
        }
        rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
    }
}
