package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryParametrizzataBella{
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getConnection()){
            String query = "select * from books where title = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "Narnia"); //questo serve per cambiare il ? con Narnia
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                System.out.println(title.length());
                System.out.println("Libro con id: " + id + " e titolo: " + title);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}