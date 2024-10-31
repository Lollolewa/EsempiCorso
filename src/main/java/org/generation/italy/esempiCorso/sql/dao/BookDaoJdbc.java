package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// Classe BookDaoJdbc che implementa l'interfaccia BookDao per gestire le operazioni sui dati di "Book" in un database SQL
public class BookDaoJdbc implements BookDao {
    // Connessione al database
    Connection connection;

    // Costruttore della classe che riceve la connessione al database
    public BookDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    // Metodo per ottenere un libro dal database tramite il suo ID
    public Optional<Book> getBookById(int id) throws DaoException {  // Query SQL con parametro per selezionare un libro in base all'ID
        String query = "SELECT * FROM books WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id); // Imposta l'ID nel parametro della query
            try(ResultSet rs = ps.executeQuery()){  // Esecuzione della query e recupero del risultato
                if (rs.next()) { // Se il libro esiste, crea un oggetto Book con i valori dal ResultSet
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("num_pages"),
                            rs.getDouble("weight"),
                            rs.getString("category"),
                            rs.getInt("publisher_id")
                    );
                    return Optional.of(book);
                }
                return Optional.empty(); // Se il libro non esiste, ritorna un Optional vuoto
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    // Metodo che dovrebbe restituire tutti i libri dal database
    public List<Book> getAllBook() throws DaoException{
        return List.of();
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws DaoException {
        return false;
    }
}
