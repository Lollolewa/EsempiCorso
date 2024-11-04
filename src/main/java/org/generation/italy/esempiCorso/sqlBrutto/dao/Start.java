package org.generation.italy.esempiCorso.sqlBrutto.dao;

import org.generation.italy.esempiCorso.sqlBrutto.DatabaseConnection;
import org.generation.italy.esempiCorso.sqlBrutto.model.Book;

import java.sql.Connection;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()){
            BookDaoJdbc bookdao = new BookDaoJdbc(connection); // vuole connection
            Book b = bookdao.getBookById(1); // throws exception
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
