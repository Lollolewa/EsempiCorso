package org.generation.italy.esempiCorso.Connection.Dao;

import org.generation.italy.esempiCorso.Connection.DataBaseConnection;
import org.generation.italy.esempiCorso.Connection.Model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
       Optional <Connection> optconnection = DataBaseConnection.getConnection();
       if(optconnection.isEmpty()){
           System.out.println("Problemi con la connessione");
           return;
       }

        try(Connection connection = optconnection.get()){
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);
            Book b = bookDao.getBookById(1);
            System.out.println(b);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
