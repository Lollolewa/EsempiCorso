package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

public class DatabaseConnection {
    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library";  // URL del database PostgreSQL
        String username = "postgresMaster";                   // Nome utente del database
        String password = "goPostgresGo";                // Password del database

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);  // Tentativo di connessione al database DriverManager classe di javaSql
            System.out.println("Connected to the PostgreSQL server successfully.");    // Messaggio di successo
            return Optional.of(conn);
        }
        catch (Exception e) {
            e.printStackTrace();                                                       // Stampa dello stack trace dell'errore
            System.out.println("Non mi posso collegare al DB");                        // Messaggio di errore
            return Optional.empty();
        }
    }
}

