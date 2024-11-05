package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    // creo i metodi astratti
    Optional<Book> getBookByID(int id) throws DaoException;
    List<Book> getAllBooks() throws DaoException;
    Book addBook(Book b) throws DaoException; // fatto principalmente per ricevere in ritorno il libro con
    // la primary key nel caso essa si autogeneri con il bigserial e quindi si creerebbe solo dopo la creazione del libro
    boolean deleteById(int id) throws DaoException;
    boolean update(Book b) throws DaoException;

}
