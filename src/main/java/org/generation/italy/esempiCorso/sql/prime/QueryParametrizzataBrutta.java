package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {

//        String myTitle = "Il Signore Degli Anelli ' or title = 'Shining' --";
        String myTitle = "Il Signore Degli Anelli; alter table books rename column title to titolo--";

        try(Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM BOOKS WHERE TITLE = '"+ myTitle+"'";
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(query); //executeQuery lo usiamo per le letture
            while (rows.next()){
                int id = rows.getInt("id");
                String title = rows.getString("title");
                System.out.printf("Book ID: %d%nTitle: %s%n%n",id,title);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }






    }
}
