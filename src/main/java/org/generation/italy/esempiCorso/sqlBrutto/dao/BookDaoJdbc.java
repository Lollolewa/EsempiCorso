package org.generation.italy.esempiCorso.sqlBrutto.dao;

import org.generation.italy.esempiCorso.sqlBrutto.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDaoJdbc implements BookDao {
    Connection connection; // oggetto di tipo connection

    public BookDaoJdbc(Connection connection) {
        this.connection = connection; // da passare al main
    }

    // prende intero (id) e restituisce un book
    @Override
    public Book getBookById(int id) throws SQLException {
        String query = "select * from books where id = ?";
        // Creo oggetto di tipo book e lo popolo con quello che dà la query:
        Book book = null;
        PreparedStatement ps = connection.prepareStatement(query);
        // sostituisco placeholder
        ps.setInt(1, id);
        // scompongo res set in books
        ResultSet rs = ps.executeQuery(); // esegue query e restituisce righe lette e ci creo oggetto
        if (rs.next()) { // anziché while
            book = new Book( // copio il book a cui corrisponde l'id cercato
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("num_pages"),
                    rs.getDouble("weight"),
                    rs.getString("category"),
                    rs.getInt("publisher_id")
            );
        }
        return book;
    }
}
