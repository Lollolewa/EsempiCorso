package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if(optCon.isEmpty()) {
            System.out.println("Problema nella creazione della connessione.");
            return;
        }
        try (Connection connection = optCon.get()) {
            BookDao bookDao = new BookDaoJdbc(connection);
            // Get book by id
            Optional<Book> ob = bookDao.getBookById(1);
            if(ob.isPresent()){
                System.out.println(ob.get());
            } else{
                System.out.println("Libro non trovato");
            }

            // add a book
            Book newBook = new Book(0, 300, 1, "Test Book", "Fiction", 1.2);
            Book addedBook = bookDao.addBook(newBook);
            System.out.println("Libro aggiunto: " + addedBook);

            // get all books
            List<Book> books = bookDao.getAllBook();
            System.out.println("Tutti i libri nel database:");
            for (Book book : books) {
                System.out.println(book);
            }

            // update a book
            if (!books.isEmpty()) {
                Book bookToUpdate = books.get(0); // Prendi il primo libro
                bookToUpdate.setTitle("Updated Title");
                boolean updated = bookDao.update(bookToUpdate);
                System.out.println("Libro aggiornato: " + updated);
                System.out.println("Libro dopo l'aggiornamento: " + bookDao.getBookById(bookToUpdate.getId()).get());
            }

            // delete a book
            if (!books.isEmpty()) {
                Book bookToDelete = books.get(0); // Prendi il primo libro
                boolean deleted = bookDao.deleteById(bookToDelete.getId());
                System.out.println("Libro eliminato: " + deleted);
            }

        } catch (DaoException | SQLException e) {
            e.printStackTrace();
        }
    }
}
