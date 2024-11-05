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
            update books set num_pages=?, publisher_id=?, title=?, category=?, weight=?
            where id=?
            """;

    private static final String INSERT_SQL =  "INSERT INTO books (title, num_pages, weight, category, publisher_id) VALUES (?,?,?,?,?)";
    private static final String DELETE_SQL =  "DELETE FROM books WHERE id =?";

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
        return List.of();
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(INSERT_SQL)){
            ps.setString(1, b.getTitle());
            ps.setInt(2, b.getNum_pages());
            ps.setDouble(3, b.getWeight());
            ps.setString(4, b.getCategory());
            ps.setInt(5, b.getPublisher_id());
            ps.executeUpdate();
        }
        catch(SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
        return b;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_SQL)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
        return false;
    }

    @Override
    public boolean update(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){

            ps.setInt(1,b.getNum_pages());
            ps.setInt(2,b.getPublisher_id());
            ps.setString(3,b.getTitle());
            ps.setString(4,b.getCategory());
            ps.setDouble(5,b.getWeight());
            ps.setInt(6,b.getId());

            int n = ps.executeUpdate(); //non esegue query ma update
            //n=numero di righe modificate dall'istruzione
            return n==1;
            //se do id che non esiste non da errore, non fa nulla
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }
}
