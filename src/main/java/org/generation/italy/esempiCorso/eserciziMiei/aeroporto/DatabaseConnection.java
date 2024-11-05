package org.generation.italy.esempiCorso.eserciziMiei.aeroporto;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

// in caso ci siano Exception relative a problemi di driver, o abbiamo scritto male le informazioni, o
// il db non esiste
public class DatabaseConnection {

    final static String jdbcUrl = "jdbc:postgresql://localhost:5432/aeroporto";
    final static String username = "postgresMaster";
    final static String password = "goPostgresGo";

    public static Connection getConnection() throws SQLException{

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        return connection;
    }
}
