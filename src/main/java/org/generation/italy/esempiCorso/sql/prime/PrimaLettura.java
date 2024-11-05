package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimaLettura {
    public static void main(String[] args) {
//        try(Connection connection = DatabaseConnection.getConnection()){ //try with resources
//            String query = "select * from books";
//            Statement st = connection.createStatement();
//            ResultSet righeLette = st.executeQuery(query); // executeQuery lo usiamo per le letture, quindi voglio leggere qualcosa
//
//            while(righeLette.next()){
//                int id = righeLette.getInt("id");
//                String title = righeLette.getString("title");
//                System.out.printf("%nLibro con id: %d e titolo: %s", id, title);
//            }
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }
}
