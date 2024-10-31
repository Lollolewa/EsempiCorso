package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao{

    Connection connection;

    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Book> getBookById(int id) throws DaoException {
        String query = "SELECT * FROM BOOKS WHERE ID = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getInt("num_pages"),
                            rs.getInt("publisher_id"),
                            rs.getDouble("weight"),
                            rs.getString("title"),
                            rs.getString("category")
                    );
                    return Optional.of(book);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
                throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Book> getAllBooks() throws DaoException {
        return List.of();
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Book book) throws DaoException {
        return false;
    }
}
