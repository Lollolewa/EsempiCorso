package org.generation.italy.esempiCorso.sql.aereoporto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    final static String jdbcUrl = "jdbc:postgresql://localhost:5432/airport";
    final static String username = "postgresMaster";
    final static String password = "goPostgresGo";

    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
        return connection;
    }
}
