package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Optional<Book> getBookById(int id) throws DaoException;

    List<Book> getAllBooks() throws DaoException;

    Book addBook(Book book) throws DaoException;

    boolean deleteById(int id) throws DaoException;

    boolean update(Book book) throws DaoException;
}

