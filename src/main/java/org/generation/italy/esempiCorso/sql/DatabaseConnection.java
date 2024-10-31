package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class DatabaseConnection {

    //CONNECTION TO DATABASE
    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library";
        String username = "postgresMaster";
        String password = "goPostgresGo";

        Connection optCon = DriverManager.getConnection(jdbcUrl, username, password);

        if(optCon.isEmpty()){
            System.out.println("Problema nella creazione della connessione");
            return;
        }
        try(Connection connection = optCon.get()){

           return Optional.of(connection);
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot create connection to DB");
            return Optional.empty();
        }
    }
}
