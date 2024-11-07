package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class QueryParametrizzataBrutta {
    public static void main(String[]args) {
        String mioTitolo = "il signore degli anelli";
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if(optCon.isEmpty()){
            return;
        }
        try(Connection connection = optCon.get()){
            String query = "select * from books where title = '" + mioTitolo + "'"; //pericoloso
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query);//executeQuery lo usiamo per le letture
            while (righeLette.next()) {
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println("libro con id: " + id + " e titolo : " + title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
