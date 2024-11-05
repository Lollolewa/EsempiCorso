package org.generation.italy.esempiCorso.sql2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnectionA {
    public static Optional<Connection> getConnection(){
        String url = "jdbc:postgresql://localhost:5432/airport";
        String username = "postgresMaster";
        String password = "goPostgresGo";

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            return Optional.of(connection);
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to connect to the db");
            return Optional.empty();
        }
    }
}
