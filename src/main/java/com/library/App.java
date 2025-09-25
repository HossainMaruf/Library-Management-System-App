package com.library;

import java.sql.Connection;
import java.util.List;

import com.db.Database;
import com.model.User;
import com.dao.UserDAO;

public class App {
    public static void main( String[] args ) throws Exception{
        String url = "jdbc:mysql://localhost:3306/library";  // Change to your DB info
        String username = "root";                               // Your DB username
        String password = "";                       // Your DB password
        Database db = new Database(url, username, password);
        if(db.connect() == 1) {
            // connection succeed 
            Connection conn = db.getConnection();
            // UserDAO userDao = new UserDAO(conn);
            // List<User> users = userDao.getAllUsers();
            // for (User user : users) {
            //     System.out.println(user.getName());
            // }
        } else {
            System.out.println("Database may be in offline!");
        } 
    }
}
