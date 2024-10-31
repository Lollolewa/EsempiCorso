package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoJdbc implements BookDao{

    Connection connection;

    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book getBookById(int id) throws SQLException {
        String query = "SELECT * FROM BOOKS WHERE ID = ?";
        Book book = null;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            book = new Book(
                    rs.getInt("id"),
                    rs.getInt("num_pages"),
                    rs.getInt("publisher_id"),
                    rs.getDouble("weight"),
                    rs.getString("title"),
                    rs.getString("category")
            );
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        return List.of();
    }
}
