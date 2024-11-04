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
    private final static String GET_ALL_BOOKS_SQL = """
            select * from books
            """;
    private final static String ADD_BOOK_SQL = """
            insert into books
            (id, num_pages, publisher_id, title, category, weight),
            values
            (?, ?, ?, ?, ?, ?);
            """;
    private final static String DELETE_BOOK_BY_ID_SQL = """
            delete from books where id = ?;
            """;
    private final static String UPDATE_SQL = """
            update books 
            set num_pages = ?, publisher_id = ?, title = ?, category = ?, weight = ?
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
        List<Book> bookList = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_ALL_BOOKS_SQL);
            ResultSet rs = ps.executeQuery();) { //A ResultSet object maintains a cursor pointing to its current row of data.
            while(rs.next()) {
                Book b = new Book(
                        rs.getInt("id"),
                        rs.getInt("num_pages"),
                        rs.getInt("publisher_id"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("weight"));
                bookList.add(b);
            }
        }
        catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }

        return bookList;
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(ADD_BOOK_SQL)) {
            //(id, num_pages, publisher_id, title, category, weight),
            ps.setInt(1, b.getId());
            ps.setInt(2, b.getNum_pages());
            ps.setInt(3, b.getPublisher_id());
            ps.setString(4, b.getTitle());
            ps.setString(5, b.getCategory());
            ps.setDouble(6, b.getWeight());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
        return b;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_BOOK_BY_ID_SQL)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n == 1;
        } catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateBook(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){
            ps.setString(1, b.getTitle());
            ps.setInt(2, b.getNum_pages());
            ps.setDouble(3, b.getWeight());
            ps.setString(4, b.getCategory());
            ps.setInt(5, b.getPublisher_id());
            ps.setInt(6, b.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return false;
    }

}
