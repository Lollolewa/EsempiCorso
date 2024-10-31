package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.util.Optional;

public class PrimaConnection {
    public static void main(String[] args) {
        Optional<Connection> conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Connessione riuscita!");
            System.out.println(conn.getClass().getName());
        } else {
            System.out.println("Connessione fallita!");
     }
    }
}
