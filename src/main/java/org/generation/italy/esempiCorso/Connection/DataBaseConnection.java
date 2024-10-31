package org.generation.italy.esempiCorso.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DataBaseConnection {


    public static Optional <Connection> getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library";
        String username = "postgresMaster";
        String password = "goPostgresGo";

        //questo è un tubo per la connessione tra java e postgres
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return Optional.of(connection);
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Non posso connettermi al database!");
            return java.util.Optional.empty();
        }
    }

}

