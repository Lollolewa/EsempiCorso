package org.generation.italy.esempiCorso.sqlBrutto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// connette con database
public class DatabaseConnection {
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library"; // versione più rudimentale
        // la stringa dice mi collego tramite jdbc:databaseNome://localhost:portaDB/nomeDB
        // Aggiungo che stringhe che danno l'username e la pasword
        String username = "postgresMaster";
        String password = "goPostgresGo";

        Connection connection = null; //tubo che collega il codice al database, dentro scorrono query e righe delle tabelle

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password); // lancia eccezione se la connessione non riesce
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Non mi posso collegare al db");
        }
        return connection;
    }
}
