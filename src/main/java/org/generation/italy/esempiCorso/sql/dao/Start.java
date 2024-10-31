package org.generation.italy.esempiCorso.sql.dao;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.model.Book;

import java.sql.Connection;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) {

        try(Connection connection = DatabaseConnection.getConnection()) {
            BookDaoJdbc bookDao = new BookDaoJdbc(connection);
            Book book = bookDao.getBookById(1);
            System.out.println(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
