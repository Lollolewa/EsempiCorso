package org.generation.italy.esempiCorso.airportManagement;

import org.generation.italy.esempiCorso.airportManagement.dao.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnection{
    final static String jdbcUrl = "jdbc:postgresql://localhost:5432/Airport";
    final static String username = "postgresMaster";
    final static String password = "goPostgresGo";

    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        return connection;
    }
}
