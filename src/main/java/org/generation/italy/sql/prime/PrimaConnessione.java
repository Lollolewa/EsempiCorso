package org.generation.italy.sql.prime;

import org.generation.italy.sql.DatabaseConnection;

import java.sql.Connection;
import java.util.Optional;

public class PrimaConnessione {
    public static void main(String[]args){
        Optional<Connection> connection = DatabaseConnection.getConnection();
        if (connection.isPresent())    {
            Connection conn = connection.get();
            System.out.println("Connessione riuscita!");
            System.out.println(connection.getClass().getName());
        } else {
            System.out.println("Connessione fallita!");
        }
    }
}