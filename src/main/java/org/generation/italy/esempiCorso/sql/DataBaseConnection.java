package org.generation.italy.esempiCorso.sql;

import java.sql.Connection; //sql
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection(){
        // versione rudimentale
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library";
        String username = "postgresMaster";
        String password = "goPostgresGo";
        Connection connection = null;
        //connection oggetto che stabilisce connessione. Un tubo dove scorrono informazioni.
        try{
            connection = DriverManager.getConnection(jdbcUrl,username,password);
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Non mi posso collegare al db");
        }
        return connection;
    }
}

//String jdbcUrl = "jdbc:postgresql://localhost:5432/library";
//String username = "postgresMaster";
//String password = "goPostgresGo";
