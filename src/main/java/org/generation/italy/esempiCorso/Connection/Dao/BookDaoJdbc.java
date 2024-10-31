package org.generation.italy.esempiCorso.Connection.Dao;

import org.generation.italy.esempiCorso.Connection.Model.Book;

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
    public Optional <Book> getBookById(int id) throws DaoException {
        String query = "select * from books where id =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id); //sostituisce il ? con il valore passato
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("num_page"),
                            rs.getString("category"),
                            rs.getDouble("weight"),
                            rs.getInt("publisher_id")
                    );
                    return Optional.of(book);

                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public void insertBook(Book book) throws DaoException {

    }

    @Override
    public boolean deleteBook(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean updateBook(Book b) throws DaoException {
        return false;
    }
}
