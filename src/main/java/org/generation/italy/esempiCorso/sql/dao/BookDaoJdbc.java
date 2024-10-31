package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao { //dao = data access object, è un intermediario tra database e applicazione

    Connection connection;

    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    public Optional<Book> getBookById(int id) throws DaoException {
        String query = "select * from books where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id); //sostituisce il ?
            try (ResultSet rs = ps.executeQuery()) { //esegue la query che contiene il ps e invia al database
                if (rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getString("titolo"),
                            rs.getInt("num_pages"),
                            rs.getDouble("weight"),
                            rs.getString("category"),
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
    public List<Book> getAllBook() throws DaoException {
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















//    @Override
//    public Book getBookById(int id) throws SQLException{
//        String query = "SELECT * FROM books WHERE id = ?";
//        Book book = null;
//        PreparedStatement ps = connection.prepareStatement(query); //questo sarà in grado di mandare la query
//        ps.setInt(1, id); //dà un parametro al posto del ?
//        ResultSet rs = ps.executeQuery(); //execute manda la query (execute) e mi restituisce un resultSet. Nel resultset ho la riga.
//        if(rs.next()) {
//            book = new Book(
//                    rs.getInt("id"),
//                    rs.getString("titolo"),
//                    rs.getInt("num_pages"),
//                    rs.getDouble("weight"),
//                    rs.getString("category"),
//                    rs.getInt("publisher_id"));
//        }
//        return book;
//    }
//
//    @Override
//    public List<Book> getAllBook() throws SQLException {
//        return List.of();
//    }
//}
