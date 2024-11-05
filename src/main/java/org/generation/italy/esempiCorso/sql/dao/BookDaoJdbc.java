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
    private static final String UPDATE_SQL = """
            update books
            set num_pages = ?, weight = ?, publisher_id = ?, title = ?, category = ?
            where id = ?
            """;
    private static final String ADD_SQL = """
            insert into books
            (id, num_pages, weight, publisher_id, title, category)
            values
            (?, ?, ?, ?, ?, ?)
            """;
    private static final String DELETE_BY_ID = """
            delete from books
            where id = ?
            """;
    private static final String GET_ALL_BOOKS = """
            select * from books
            """;
    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Book> getBookByID(int id) throws DaoException{
        String query = "select * from books where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getInt("num_pages"),
                            rs.getDouble("weight"),
                            rs.getInt("publisher_id"),
                            rs.getString("title"),
                            rs.getString("category")
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
    public List<Book> getAllBooks() throws DaoException{
        List<Book> books = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_ALL_BOOKS);
            ResultSet rs = ps.executeQuery();){
            while(rs.next()){
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getInt("num_pages"),
                        rs.getDouble("weight"),
                        rs.getInt("publisher_id"),
                        rs.getString("title"),
                        rs.getString("category")
                );
                //aggiungo il libro alla lista
                books.add(book);
            }
            return books;

        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(ADD_SQL)){
            ps.setInt(2, b.getNumPages());
            ps.setDouble(3, b.getWeight());
            ps.setInt(4, b.getPublisherId());
            ps.setString(5, b.getTitle());
            ps.setString(6, b.getCategory());
            ps.setInt(1, b.getId());

            ps.executeUpdate();
            return b;
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID)){
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n == 1;
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Book b) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){
            ps.setInt(1, b.getNumPages());
            ps.setDouble(2, b.getWeight());
            ps.setInt(3, b.getPublisherId());
            ps.setString(4, b.getTitle());
            ps.setString(5, b.getCategory());
            ps.setInt(6, b.getId());

            int n = ps.executeUpdate(); //numero di righe modificate dall'istruzione
            return n == 1;
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }
}
