package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.model.User;

public class UserDAO {
    String sql = "";
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    User user = null;
    List<User> users = null;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    private User userFromResultSet(ResultSet rs) throws SQLException {
        user = new User(
            rs.getInt("id"), 
            rs.getString("name"), 
            rs.getString("email"), 
            rs.getString("phone"));
        return user;
    }

    private List<User> usersFromResultSet(ResultSet rs) throws SQLException{
        while(rs.next()) { users.add(userFromResultSet(rs)); }
        rs.close();
        return users;
    }

    public List<User> getAllUsers() {
        users = new ArrayList<User>();
        try {
            sql = "select * from users";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            return usersFromResultSet(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
