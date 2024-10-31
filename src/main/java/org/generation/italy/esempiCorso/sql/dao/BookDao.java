package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    Optional<Book> getBookById(int id) throws DaoException;
    List<Book> getAllBook() throws DaoException;
    Book addBook(Book b) throws DaoException;
    boolean deleteById(int id) throws DaoException;
    boolean update(Book b) throws DaoException;
}
//    Optional<Book> getBookById(int id) throws DaoException; //così lancerà solo questa eccezione, meglio se mettiamo solo throws Exception
//    //questo però comporta dover fare un catch di Exception, che è complicato da gestire. QUesto non vogliamo farlo.
//
//    List<Book> getAllBook() throws DaoException; //Anche Exception non va bene, quindi mi creo una eccezione customizzata


