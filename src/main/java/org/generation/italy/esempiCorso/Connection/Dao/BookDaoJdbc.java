package org.generation.italy.esempiCorso.Connection.Dao;

import org.generation.italy.esempiCorso.Connection.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoJdbc implements BookDao{
    private static final String UPDATE_SQL = """
            update books set num_page=?, publisher id = ?, title=?,category=?,weight=?
            where id=?
            """;
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
    public List<Book> getAllBooks() throws DaoException {
        List<Book> books = new ArrayList<>();
        String query = "select * from books";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("num_page"),
                            rs.getString("category"),
                            rs.getDouble("weight"),
                            rs.getInt("publisher_id")
                    );
                    books.add(book);
                }return books;
            }catch (SQLException e){
                throw new DaoException(e.getMessage(),e);


        }


    }


    @Override
    public Book insertBook(Book book) throws DaoException {
       String update = "insert into books(id,title,num_page,category,weight,publisher_id) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(update)){
            ps.setInt(1,book.getId());
            ps.setString(2,book.getTitle());
            ps.setInt(3,book.getNum_page());
            ps.setString(4,book.getCategory());
            ps.setDouble(5,book.getWeight());
            ps.setInt(6,book.getPublisherId());
            ps.executeUpdate();
            return book;
        } catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }


    }

    @Override
    public boolean deleteBook(int id) throws DaoException {
        String query = "delete from books where id =?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0; //ritorna true se ha rimosso una riga false se non ha rimosso nulla
        } catch (SQLException e ){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean updateBook(Book b) throws DaoException {
       try(PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)){
           ps.setInt(1,b.getNum_page());
           ps.setInt(2,b.getPublisherId());
           ps.setString(3,b.getTitle());
           ps.setString(4,b.getCategory());
           ps.setDouble(5,b.getWeight());
           ps.setInt(6,b.getId());
           int n = ps.executeUpdate();
           return n == 1; //ritorna true se ha modificato una riga false se non ha rimosso nulla
       } catch (SQLException e){
           throw new DaoException(e.getMessage(),e);
       }

    }
}
