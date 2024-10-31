package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[]args){
        String mioTitolo = "il signore degli anelli";
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "select * from books where title = '" + mioTitolo + "'";
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query);
            while(righeLette.next()){
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println("libro con id: " +id + " e titolo : " + title);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
