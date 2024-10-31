package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class QueryParametrizzataBrutta {
    public static void main(String[]args){
        String mioTitolo = "il signore degli anelli";
        Optional<Connection> optConn = DatabaseConnection.getConnection();
        if (optConn.isEmpty()) {
            return;
        }
        try(Connection conn = optConn.get()){
            String query = "select * from books where title = '" + mioTitolo + "'";
            Statement statement = conn.createStatement();
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
