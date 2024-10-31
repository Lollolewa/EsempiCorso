package org.generation.italy.sql.prime;

import org.generation.italy.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class QueryParametrizzataBella {
    public static void main(String[]args){

        try(Optional<Connection> connection = DatabaseConnection.getConnection()){
            String query = "select * from books where title = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "il signore degli anelli");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                System.out.println("libro con id: " +id + " e titolo : " + title);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
