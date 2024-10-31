package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    Book getBookById(int id) throws SQLException;

    List<Book> getAllBooks() throws SQLException;
}

