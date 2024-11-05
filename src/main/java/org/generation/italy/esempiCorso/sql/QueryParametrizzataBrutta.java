package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {
        try(Connection connection = DataBaseConnection.getConnection()){
            String query = "select * from books where title = 'Dune' ";
            Statement statement = connection.createStatement();
            ResultSet righelette = statement.executeQuery(query); //executeQuery lo usiamo per le letture.
            while(righelette.next()){ //next chiede se ce una riga dopo, se true passa alla riga dopo,senno si esce dal while
                int id = righelette.getInt("id");
                String title = righelette.getString("title");
                System.out.println("Libro con id: " + id + " e titolo " + title);
        } }
        catch (SQLException e){
            e.printStackTrace();
        }
        }
    }

