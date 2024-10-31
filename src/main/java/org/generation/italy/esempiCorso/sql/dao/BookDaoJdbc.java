package org.generation.italy.esempiCorso.sql.dao;
import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// tutti gli ordini sono straniiii
public class BookDaoJdbc implements BookDao{
    Connection connection;
    //rivedi
    private static final String UPDATE_SQL = """
            update books set
            title = ?, num_pages = ?, weight = ?, category = ?, publisher_id = ? 
            where id = ?;
            """;

    private static final String INSERT_SQL = """
            insert into books(id, title, num_pages, category, weight)
            values(?, ?, ?, ?, ?);
            """;

    private static final String SELECT_SQL = """
            select * from books;
            """;

    private static final String DELETE_SQL = """
            delete from books
            where id = ?;
            """;


    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Book> getBookById(int id) throws DaoException{
        String query = "select * from books where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id); //sostituisce il ?
            try(ResultSet rs = ps.executeQuery()){ //esegue la query che contiene il ps e invia al database
                if(rs.next()) {
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
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Book> getAllBook() throws DaoException{
        List<Book> books = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int num_pages = rs.getInt("num_pages");
                double weight = rs.getDouble("weight");
                String category = rs.getString("category");
                int publisher_id = rs.getInt("publisher_id");

                Book b = new Book(id, num_pages, publisher_id, title, category, weight);
                books.add(b);
            }
            return books;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
            ps.setInt(1, b.getId()); // se non fosser stato autogenerato, dovevo metterlo in book e ritornare l'id
            ps.setString(2, b.getTitle());
            ps.setInt(3, b.getNum_pages());
            ps.setString(4, b.getCategory());
            ps.setDouble(5, b.getWeight());
            // id di books non è autogenerato
            ps.executeUpdate();
            return b;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n == 1;
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
