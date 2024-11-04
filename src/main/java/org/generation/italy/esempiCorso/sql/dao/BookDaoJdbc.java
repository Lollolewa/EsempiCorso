package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao{
    Connection connection;
    private static final String UPDATE_SQL = """
            update books set num_page=?, publisher id = ?, title=?,category=?,weight=?
                        where id=?
            """;
    public BookDaoJdbc(Connection connection){
        this.connection=connection;
    }
    @Override
    public Optional<Book> getBookById(int id) throws DaoException {
        String query = "select * from books where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
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
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
   @Override
   public List<Book> getAllBook() throws DaoException{
//        String query = "select * from books";
//        List<Book> books = new ArrayList<>();
//        try(PreparedStatement ps = connection.prepareStatement(query)){
//            try(ResultSet rs = ps.executeQuery()){
//                while(rs.next()){
//                    books.add(rs);
//                }
//
//            }
//        }catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
       return List.of();
    }

    @Override
    public Book addBook(Book b) throws DaoException {
        String query = "insert into books (id, num_page, publisher id, title, category, weight) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,b.getId());
            ps.setInt(2,b.getNum_pages());
            ps.setInt(3,b.getPublisher_id());
            ps.setString(4,b.getTitle());
            ps.setString(5,b.getCategory());
            ps.setDouble(6,b.getWeight());

            ps.executeUpdate();
            return b;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }

    }

    @Override
    public boolean deleteById(int id) throws DaoException {
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
