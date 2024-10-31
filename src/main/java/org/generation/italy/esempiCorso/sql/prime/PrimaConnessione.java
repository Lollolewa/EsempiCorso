package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import java.sql.Connection;
import java.util.Optional;

public class PrimaConnessione {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if (optCon.isPresent()){
            Connection connection = optCon.get();
            System.out.println("Connessione riuscita :)");
            System.out.println(connection.getClass().getName());
        }else{
            System.out.println("Connessione fallita :(");
        }
    }
}