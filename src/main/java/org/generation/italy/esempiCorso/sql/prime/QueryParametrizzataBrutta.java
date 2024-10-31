package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {
//        String mioTitolo = "Narnia";
        //String mioTitolo = "Narnia' or title = 'Roma' --"; //volevo solo Narnia, così mi dà sia Narnia che Roma;
        String mioTitolo = "Narnia'; ALTER TABLE books rename column title to titolo; --"; //in questo modo la colonna title è diventata titolo

        //Questo è chiamato SQL Injection, che permette Attaccare il database, andando ad alterare o anche droppare addirittura il database tramite le query
        try(Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM books WHERE title = '" + mioTitolo + "'"; //l'apice singolo è pericoloso perchè se usassimo questo tipo di scrittura
            //con uno scanner, un utente potrebbe chiudere l'apice singolo dopo il nome del titolo e creare problemi col database; ESEMPI SOPRA CON MIOTITOLO

            //Per risolvere questo problema guardare la classe QueryParametrizzataBella

            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query);
            while (righeLette.next()) {
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println("Libro con id " + id + ", titolo: " + title);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
