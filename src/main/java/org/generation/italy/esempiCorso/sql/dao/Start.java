package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
//branch nuova
public class Start {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if(optCon.isEmpty()) {
            System.out.println("Problema nella creazione della connessione.");
            return;
        }
        try (Connection connection = optCon.get()) {
            BookDao bookDao = new BookDaoJdbc(connection);
            Optional<Book> ob = bookDao.getBookById(1);
            if(ob.isPresent()){
                System.out.println(ob.get());
            } else{
                System.out.println("Libro non trovato");
            }

        } catch (DaoException | SQLException e) {
            e.printStackTrace();
        }

    }
}
