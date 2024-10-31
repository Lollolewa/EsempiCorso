package org.generation.italy.sql.prime;

import org.generation.italy.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[]args){
       String mioTitolo = "il signore degli anelli";

        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "select * from books where title = '" + mioTitolo + "'"; //pericoloso
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query);//executeQuery lo usiamo per le letture
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
