package org.generation.italy.esempiCorso.sql.books.dao;

import org.generation.italy.esempiCorso.sql.books.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    Optional<Book> getBookById(int id) throws DaoException;
    List<Book> getAllBook() throws DaoException;
    Book addBook(Book book) throws DaoException;
    boolean deleteById(int id) throws DaoException;
    boolean updateBook(Book book) throws DaoException;
}
