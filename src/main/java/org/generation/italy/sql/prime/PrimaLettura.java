package org.generation.italy.sql.prime;

import org.generation.italy.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class PrimaLettura {
    public static void main(String[] args) {
        // Otteniamo la connessione utilizzando l'Optional
        Optional<Connection> optCon = DatabaseConnection.getConnection();

        // Controlliamo se la connessione è presente
        if (optCon.isPresent()) {
            try (Connection connection = optCon.get(); // Proviamo a utilizzare la connessione
                 Statement statement = connection.createStatement()) {

                String query = "SELECT * FROM books"; // Query per selezionare tutti i libri
                ResultSet righeLette = statement.executeQuery(query); // Eseguiamo la query

                // Iteriamo sui risultati
                while (righeLette.next()) {
                    int id = righeLette.getInt("id");
                    String title = righeLette.getString("title");
                    System.out.println("Libro con ID: " + id + " e titolo: " + title);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Gestiamo eventuali eccezioni SQL
            }
        } else {
            System.out.println("Impossibile stabilire la connessione al database.");
        }
    }
}