package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnection {

    //CONNECTION TO DATABASE
    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library"; //la versione più bruttina
        String username = "postgresMaster";
        String password = "goPostgresGo";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return Optional.of(connection);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Cannot create connection to DB"); //per db si intende database
            return Optional.empty();
        }
    }
}

