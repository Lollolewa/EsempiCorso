package org.generation.italy.esempiCorso.ravenclaw.sql.airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DBconnection {
    //CONNECTION TO DATABASE
    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://192.168.1.3/airportmanagement"; //la versione più bruttina
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
