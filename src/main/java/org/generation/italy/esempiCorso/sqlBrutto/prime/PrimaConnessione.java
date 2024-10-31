package org.generation.italy.esempiCorso.sqlBrutto.prime;

import org.generation.italy.esempiCorso.sqlBrutto.DatabaseConnection;

import java.sql.Connection;

public class PrimaConnessione {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.printf("Connessione riuscita");
        } else {
            System.out.println("connessione fallita");
        }
    }
}

