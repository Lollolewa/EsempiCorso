package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstReading {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "select * from books";
            Statement st = connection.createStatement();
           ResultSet readedLines = st.executeQuery(query); //execute query usato per le letture, per inserie e modificare solo execute
            while(readedLines.next()){
                int id = readedLines.getInt("id");
                String title = readedLines.getString("title");
                System.out.println("id "  + id + " title " + title);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
