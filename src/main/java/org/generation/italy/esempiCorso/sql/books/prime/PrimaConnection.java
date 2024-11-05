package org.generation.italy.esempiCorso.sql.books.prime;

import org.generation.italy.esempiCorso.sql.books.DatabaseConnection;

import java.sql.Connection;
import java.util.Optional;

public class PrimaConnection {
    public static void main(String[] args) {
        Optional<Connection> optConn = DatabaseConnection.getConnection();
        if (optConn.isPresent())    {
            Connection conn = optConn.get();
            System.out.println("Connessione riuscita!");
            System.out.println(optConn.getClass().getName());
        } else {
            System.out.println("Connessione fallita!");
     }
    }
}
