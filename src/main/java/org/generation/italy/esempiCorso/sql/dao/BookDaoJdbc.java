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

    private static final String UPDATE_SQL = """
            update books set num_pages = ?, publisher_id = ?, title= = ?, category = ?, weight = ?, id = ?
            where id = ?
            """;
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
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){
            ps.setInt(1,book.getNum_pages());
            ps.setInt(2,book.getPublisher_id());
            ps.setString(3,book.getTitle());
            ps.setString(4,book.getCategory());
            ps.setDouble(5,book.getWeight());
            ps.setInt(6,book.getId());
            int n = ps.executeUpdate();
            return n == 1;
        }catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }
}
