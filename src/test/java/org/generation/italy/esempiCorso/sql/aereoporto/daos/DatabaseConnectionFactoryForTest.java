package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactoryForTest {

    final static String jdbcUrl = "jdbc:postgresql://localhost:5432/aeroporto";
    final static String username = "postgresMaster";
    final static String password = "goPostgresGo";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
        return connection;

    }

}
