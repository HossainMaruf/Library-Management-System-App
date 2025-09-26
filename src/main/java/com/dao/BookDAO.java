package com.dao;

<<<<<<< HEAD
public class BookDAO {
    
}
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.model.Book;

public class BookDAO {
    String sql = "";
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Book book = null;
    List<Book> books = null;

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    private Book bookFromResultSet(ResultSet rs) throws SQLException {
        book = new Book(
            rs.getInt("id"), 
            rs.getString("title"), 
            rs.getString("author"), 
            rs.getString("isbn"), 
            rs.getString("publishedYear"));
        return book;
    }

    private List<Book> booksFromResultSet(ResultSet rs) throws SQLException{
        while(rs.next()) { books.add(bookFromResultSet(rs)); }
        rs.close();
        return books;
    }

    public List<Book> getAllUsers() {
        books = new ArrayList<Book>();
        try {
            sql = "select * from books";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            return booksFromResultSet(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public int insertBook(Book book) {
        try {
            sql = "insert into books (ttile, author, isbn, publishedYear) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setString(4, book.getPublishedYear());
            return statement.executeUpdate(); // return the number of affected rows
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isBookExist(String id) {
        try {
            sql = "select * from books where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if(rs.next() == false) return false;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

>>>>>>> 2f3ed134ae5142bf1af278e79e0670cdd691e7df
