package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QueryPersonalizzataBella {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Search Book: ");
        String res = sc.nextLine();

        try(Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM BOOKS WHERE TITLE = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,res);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                System.out.printf("Book ID: %d%nTitle: %s%n%n",id,title);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
