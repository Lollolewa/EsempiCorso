package org.generation.italy.sql.dao;

import org.generation.italy.sql.DatabaseConnection;
import org.generation.italy.sql.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[]args){
        Optional<Connection> optConn = DatabaseConnection.getConnection();
        if(optConn.isEmpty()){
            System.out.println("impossibile connettersi al databse");
            return;
        }
        try(Connection conn = optConn.get()){
            BookDaoJdbc bookDao = new BookDaoJdbc(conn);
            Optional<Book> b = bookDao.getBookById(1);
            System.out.println(b);
        }
        catch (SQLException | DaoException e) {
            e.printStackTrace();
        }
    }
}
