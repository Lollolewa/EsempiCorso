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
            System.out.println("Problema neòòa creazione della connessione");
            return;
        }
        try(Connection connection = optCon.get()){
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);
            //Book b = bookDao.getBookByID(1);
            //System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
