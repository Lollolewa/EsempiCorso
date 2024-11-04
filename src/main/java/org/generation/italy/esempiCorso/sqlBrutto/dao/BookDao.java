package org.generation.italy.esempiCorso.sqlBrutto.dao;

import org.generation.italy.esempiCorso.sqlBrutto.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    // Metodi per le operazioni sulla tabella
    Book getBookById(int id) throws SQLException; // trova libro dall'id
}
