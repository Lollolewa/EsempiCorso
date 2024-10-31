package org.generation.italy.esempiCorso.sql;

import java.sql.Connection; //sql :(
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnection{
    //finalmente JJAAAAVAA🚀
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
            System.out.println("Non mi posso collegare al db :("); //per db si intende database
            return Optional.empty();
        }
    }
}
