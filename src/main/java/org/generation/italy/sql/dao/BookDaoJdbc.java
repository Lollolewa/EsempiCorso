package org.generation.italy.sql.dao;

import org.generation.italy.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao{
    Connection connection;
    private static final String UPDATE_SQL = """
            update books set num_pages = ?, publisher_id = ?, title = ?, category = ?, weight = ? 
            where id=?
            """;
    private static final String DELETE_SQL = "delete books where id = ?";

    private static final String ADD_SQL = """ 
            insert into books (num_pages, publisher_id, title, category, weight,id) 
            values (?, ?, ?, ?, ?, ?)
            """;
    private static final String ALL_BOOKS = "select * from books";
    List<Book> books = new ArrayList<>();

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
    public List<Book> getAllBook() throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(ALL_BOOKS);
            ResultSet rs = ps.executeQuery();) {
            while (rs.next()){
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

    @Override
    public Book addBook(Book b) throws DaoException {
       try(PreparedStatement ps = connection.prepareStatement(ADD_SQL)){
           ps.setInt(1, b.getNum_pages());
           ps.setInt(2, b.getPublisher_id());
           ps.setString(3, b.getTitle());
           ps.setString(4, b.getCategory());
           ps.setDouble(5, b.getWeight());
           ps.setInt(6, b.getId());

           ps.executeUpdate();
           return b;
       }catch(SQLException e){
           throw new DaoException(e.getMessage(), e);
       }
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_SQL)){
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n==1;
        }catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){
            ps.setInt(1, b.getNum_pages());
            ps.setInt(2, b.getPublisher_id());
            ps.setString(3, b.getTitle());
            ps.setString(4, b.getCategory());
            ps.setDouble(5, b.getWeight());
            ps.setInt(6, b.getId());

            int n = ps.executeUpdate();
            return n == 1;
        }catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }
}
