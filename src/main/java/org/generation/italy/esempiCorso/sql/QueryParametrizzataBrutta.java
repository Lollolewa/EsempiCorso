package org.generation.italy.esempiCorso.sql;

import java.sql.*;

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {

        try(Connection connection = DatabaseConnection.getConnection()) {
            String query = "select * from books where title = 'DarkGay'";
            Statement st = connection.createStatement();
            ResultSet readedLines = st.executeQuery(query);
            while(readedLines.next()){
            int id = readedLines.getInt("id");
            String title = readedLines.getString("title");
                System.out.println(title.length());
                System.out.println("id " + id + " title "+ title);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
