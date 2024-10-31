package org.generation.italy.esempiCorso.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library";// versione nabba
        String username = "postgresMaster";
        String password = "goPostgresGo";

        Connection connection = null;

        try{

            connection = DriverManager.getConnection(jdbcUrl,username,password);
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("can't connect to db");
        }
        return connection;
    }
}
