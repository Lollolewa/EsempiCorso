package org.generation.italy.sql.dao;

import org.generation.italy.sql.model.Book;

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
        String query = "select * from books where id = ?";
        try( PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {// se c'e' la riga
                    Book book = new Book(// prende il book e lo crea tramite il suo costruttore
                            rs.getInt("id"),
                            rs.getInt("num_pages"),
                            rs.getInt("publisher_id"),
                            rs.getString("title"),
                            rs.getString("category"),
                            rs.getDouble("weight")
                    );
                    return Optional.of(book);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
            // PreparedStatement ps = connection.prepareStatement(query);// sara' in grado di mandare la query al databse
            //ps.setInt(1, id); // sostituisce il punto interrogativo
            // ResultSet rs = ps.executeQuery();// qui esegue la query che contiene il ps e la invia al database
            // se e' andato tutto bene mi restituira' il book
    }
    @Override
    public List<Book> getAllBook() {
        return List.of();
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Book b) throws DaoException {
        return false;
    }

}
