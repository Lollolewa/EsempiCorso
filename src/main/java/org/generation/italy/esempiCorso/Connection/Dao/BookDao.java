package org.generation.italy.esempiCorso.Connection.Dao;

import org.generation.italy.esempiCorso.Connection.Model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    Optional <Book> getBookById(int id) throws DaoException;
    List<Book> getAllBooks() throws DaoException;
    Book insertBook(Book book) throws DaoException;
    boolean deleteBook(int id) throws DaoException;
    boolean updateBook(Book b) throws DaoException;

}
