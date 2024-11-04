package org.generation.italy.esempiCorso.sqlBrutto.prime;

import org.generation.italy.esempiCorso.sqlBrutto.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/// questo codice non va bene per quell'apostrofo (apice):
/// magari è preso come input dall'utente il titolo, allora potrei mettere io l'apice finale e scrivere anche modificare db

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {
        String mioTitolo = "narnia";
        // mette due libri
        //String mioTitolo = "narnia' or title = 'dune' --commenta quello che c'è dopo(';)";
        // l'utente rompe titolo perché lo rinomina: attacco tramite query!!!!
        //String mioTitolo = "narnia'; alter table books rename column title to titolo--";
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "select * from books where title = '" + mioTitolo + "'";
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query);
            while (righeLette.next()) {
                int id = righeLette.getInt("id"); // leggi riga in quella colonna e metti lì il valore
                String title = righeLette.getString("title");
                System.out.println("libro con id: " + id + " dal titolo " + title);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

