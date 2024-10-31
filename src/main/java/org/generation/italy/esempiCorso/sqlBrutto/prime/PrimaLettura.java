package org.generation.italy.esempiCorso.sqlBrutto.prime;

import org.generation.italy.esempiCorso.sqlBrutto.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaLettura {
    public static void main(String[] args) {
        // crea e chiude connessione con try with resources
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "select * from books"; // query da mandare
            // creo oggetto che trasposrta la query: è uno statement
            Statement statement = connection.createStatement();
            // oggetto connection ha metodo createStatement() che restituisce uno statement
            ResultSet righeLette = statement.executeQuery(query); // prende stringa con query di sola lettura
            while (righeLette.next()) { // vede se c'è la riga e va avanti
                int id = righeLette.getInt("id"); // leggi riga in quella colonna e metti lì il valore
                String title = righeLette.getString("title");
                System.out.println("libro con id: " + id + " dal titolo " + title);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
