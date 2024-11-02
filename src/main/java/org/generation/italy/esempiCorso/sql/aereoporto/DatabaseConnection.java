package org.generation.italy.esempiCorso.sql.aereoporto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnection {
    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/airport";
        String username = "postgresMaster";
        String password = "goPostgresGo";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            return Optional.of(connection);

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("non mi posso collegare al db");
            return Optional.empty();
        }

    }

}
