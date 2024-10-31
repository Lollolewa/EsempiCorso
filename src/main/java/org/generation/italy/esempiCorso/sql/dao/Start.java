package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if(optCon.isEmpty()){
            System.out.println("Problema nella creazione della connessione.");
            return;
        }

        try(Connection connection = optCon.get()){
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);
            Optional<Book> b = bookDao.getBookById(8);
            if(ob.isPresent()){
                System.out.println(ob.get());
            }else {
                System.out.println("Book not found");
            }
            System.out.println(b);
        }
        catch (DaoException e){
            e.printStackTrace();
        }
    }
}
