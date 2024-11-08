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
        if(optCon.isEmpty()){
            System.out.println("Problema nella creazione della connessione.");
            return;
        }


        try(Connection connection = optCon.get()) {
            // Uso della connessione per ottenere il BookDaoJdbc e altre operazioni
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);

            // Primo utilizzo per ottenere un libro con ID 9
            Optional<Book> book = bookDao.getBookById(9);
            if(book.isPresent()) {
                System.out.println(book.get());
            } else {
                System.out.println("Book not found");
            }



            System.out.println();




            // Secondo utilizzo per ottenere tutti i libri
            List<Book> books = bookDao.getAllBooks();
            books.forEach(System.out::println);




            bookDao.deleteById(4);
            System.out.println();




            List<Book> books1 = bookDao.getAllBooks();
            books1.forEach(System.out::println);




//            Book book4 = new Book(4, 999, 2, "DarkGay", "Erotic", 69);
//            bookDao.addBook(book4);




            System.out.println("\n");
            List<Book> books2 = bookDao.getAllBooks();
            books2.forEach(System.out::println);



        } catch (DaoException | SQLException e) {
            e.printStackTrace();
        }

    }
}
