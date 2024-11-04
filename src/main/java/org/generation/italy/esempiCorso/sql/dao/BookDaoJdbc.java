package org.generation.italy.esempiCorso.sql.dao;
import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao{
    Connection connection;
    private static final String SELECT_ID_SQL = """
            select * from books
            where id = ?;
            """;
    private static final String SELECT_SQL = """
            select * from books;
            """;
//    private final static String INSERT_SQL = """
//            insert into books(id, title, num_pages, weight, category, publisher_id)
//            values(?, ?, ?, ?, ?, ?);
//            """;
    private final static String INSERT_SQL = """
            insert into books(title, num_pages, weight, category, publisher_id)
            values (?, ?, ?, ?, ?);
            """;
    private static final String DELETE_SQL = """
            delete from books
            where id = ?;
            """;
    private final static String UPDATE_SQL = """
            UPDATE books
            SET title = ?, num_pages = ?, weight = ?, category = ?, publisher_id = ?
            WHERE id = ?;
            """;

    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Book> getBookById(int id) throws DaoException{
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ID_SQL)) {
            ps.setInt(1, id); // sostituisce il ?
            try (ResultSet rs = ps.executeQuery()){ //esegue la query che contiene il ps e invia al database; rs può essere vuoto -> try (una sola riga -> try with res)
                if (rs.next()) {
                    Book book = new Book(
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
        } catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Book> getAllBook() throws DaoException{
        List<Book> books = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
             ResultSet rs = ps.executeQuery()) { // Risorse utilizzate per brevi porzioni di logica possono essere chiuse separatamente (come sopra)
            // Risorse utilizzate fino alla fine del metodo (ad es. cicli su molti risultati):
            // è possibile includerle in un unico blocco try-with-resources esterno (questo caso)
            while (rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getInt("num_pages"),
                        rs.getInt("publisher_id"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("weight")
                );
                books.add(b);
            }
            return books;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

//    @Override
//    public Book addBook(Book b) throws DaoException {
//        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
//            ps.setInt(1, b.getId());
//            ps.setString(2, b.getTitle());
//            ps.setInt(3, b.getNum_pages());
//            ps.setString(4, b.getCategory());
//            ps.setDouble(5, b.getWeight());
//            ps.executeUpdate();
//            return b;
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }

    @Override
    public Book addBook(Book b) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
            ps.setString(1, b.getTitle());
            ps.setInt(2, b.getNum_pages());
            ps.setDouble(3, b.getWeight());
            ps.setString(4, b.getCategory());
            ps.setInt(5, b.getPublisher_id());
            int n = ps.executeUpdate();
            if (n == 0) {
                throw new DaoException("Creating book failed");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) { // se ps ha generato una chiave questa è restituita
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1); // prima key
                    b.setId(id);
                } else {
                    throw new DaoException("no ID obtained.");
                }
            }
            return b;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Book b) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setInt(1, b.getNum_pages());
            ps.setInt(2, b.getPublisher_id());
            ps.setString(3, b.getTitle());
            ps.setString(4, b.getCategory());
            ps.setDouble(5, b.getWeight());
            ps.setInt(6, b.getId());

            int n = ps.executeUpdate(); // ritorna il numero di righe modificate (qui 1 o 0)
            return n == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
