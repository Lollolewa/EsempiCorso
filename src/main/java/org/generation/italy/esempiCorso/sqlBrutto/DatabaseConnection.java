package org.generation.italy.esempiCorso.sqlBrutto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// connette con database
public class DatabaseConnection {
    public static Connection getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library"; // versione più rudimentale
        // la stringa dice mi collego tramite jdbc:databaseNome:portadatabase/nomedatab
        // mancano stringhe che dico username e pass
        String username = "postgresMaster";
        String password = "goPostgresGo";

        Connection connection = null; //tubo

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password); // ha sql exception
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Non mi posso collegare al db");
        }
        return connection;
    }
}
