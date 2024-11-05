package org.generation.italy.esempiCorso.sql;

import java.sql.Connection; //si connette con SQL
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

// in caso ci siano Exception relative a problemi di driver, o abbiamo scritto male le informazioni, o
// il db non esiste
public class DatabaseConnection {
    public static Optional<Connection> getConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/aeroporto";
        String username = "postgresMaster";
        String password = "goPostgresGo";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return Optional.of(connection);

        } catch (SQLException e) {
            e.printStackTrace(); //mi stampa a schermo tutta la traccia dei metodi di un'eccezione
            System.out.println("Non mi posso collegare al db :(");
            return Optional.empty();
        }
    }
}
