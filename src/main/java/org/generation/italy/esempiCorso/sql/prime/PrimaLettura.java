package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaLettura {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM books";
            Statement statement = connection.createStatement(); //Statement è un oggetto che trasporta informazioni al db, permettendoci di eseguire le query
                                                                //sul nostro db
            ResultSet righeLette = statement.executeQuery(query); //executeQuery() lo usiamo per le letture e gli passiamo una query
            //l'executequery lo inseriamo dentro un ResultSet, che è ciò che l'execute mi restituisce
            while(righeLette.next()) {
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println("Libro con id " + id + ", titolo: " + title);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
