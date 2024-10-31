package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;

public class PrimaConnessione {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if(connection != null) {
            System.out.println("Connessione riuscita!");
        } else {
            System.out.println("Connessione fallita!");
        }

    }
}
