package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaLettura {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query); //executeQuery lo usiamo per le letture, quindi proprio query nel senso stretto
            while(righeLette.next()){
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println(title.length());
                System.out.println("Libro con id: " + id + " e titolo: " + title);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
