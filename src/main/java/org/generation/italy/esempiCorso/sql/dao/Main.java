package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args)  {
        Optional<Connection> optConn = DatabaseConnection.getConnection();
        if (optConn.isEmpty()) {
            System.out.println("Impossibile connettersi al database");
            return; // Se non si può connettersi, esce dal main

        }
        try (Connection conn = optConn.get()){
            BookDaoJdbc bookDao = new BookDaoJdbc(conn);
            Optional <Book> ob = bookDao.getBookById(1);
            System.out.println("Libro trovato: " + ob); // Stampa il libro trovato

        } catch (SQLException e) {
            e.printStackTrace(); // Stampa l'eccezione se si verifica un errore
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
