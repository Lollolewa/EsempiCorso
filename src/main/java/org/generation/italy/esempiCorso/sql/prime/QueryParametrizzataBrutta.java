package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryParametrizzataBrutta {
    public static void main(String[] args) {
        //String mioTitolo = "Casper' or title = 'Il signore degli Anelli";
        String mioTitolo = "";
//        try(Connection connection = DatabaseConnection.getConnection()){
//            //String query = "select * from books where title = '" + mioTitolo + "'";
//            String query = String.format("select * from books where title = '%s'", mioTitolo);
//            Statement st = connection.createStatement();
//            ResultSet righeLette = st.executeQuery(query); // executeQuery lo usiamo per le letture, quindi voglio leggere qualcosa
//
//            while(righeLette.next()){
//                int id = righeLette.getInt("id");
//                String title = righeLette.getString("title");
//                System.out.printf("%nLibro con id: %d e titolo: %s", id, title);
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }
}
