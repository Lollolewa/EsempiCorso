package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if (optCon.isEmpty()) {
            System.out.println("Impossibile connettersi al database");
            return; // Se non si può connettersi, esce dal main

        }
        try (Connection connection = optCon.get()) {
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);
            Optional<Book> ob = bookDao.getBookById(1);
            if(ob.isPresent()){
                System.out.println(ob.get());
            }
            else {
                System.out.println("Libro non trovato."); // Stampa il libro trovato
            }
        } catch (DaoException | SQLException e) {
            e.printStackTrace(); // Stampa l'eccezione se si verifica un errore
        }
    }
}