package org.generation.italy.esempiCorso.sql.books.prime;

import org.generation.italy.esempiCorso.sql.books.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class PrimaLettura {
    public static void main(String[] args) {
        // Stabilisce una connessione al database
        Optional<Connection> optConn = DatabaseConnection.getConnection();
        if (optConn.isEmpty()){
            return;
        }
        try(Connection conn = optConn.get()){
            // Query SQL per selezionare tutti i libri
            String query = "select * from books";
            // Crea uno statement per eseguire la query
            Statement stmt = conn.createStatement();
            // Esegue la query e ottiene il risultato
            ResultSet rs = stmt.executeQuery(query);
            // Itera sui risultati
            while(rs.next()){
                // Estrae i dati da ogni riga
                int id = rs.getInt("id");
                String titolo = rs.getString("title");
                String autore = rs.getString("authors");
                // Stampa i dati del libro
                System.out.println("ID: " + id + ", Titolo: " + titolo + ", Autore: " + autore);
            }
        }
        // Gestisce eventuali eccezioni
        catch (Exception e){
            e.printStackTrace();
        }
    }
}