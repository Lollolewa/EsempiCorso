package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class QueryParametrizzataBrutta { //le query sono tutte belle ma questa è brutta
    public static void main(String[] args) {
        //String mioTitolo = "Narnia' or title = 'Dune' --";
        String mioTitolo = "Narnia'; alter table books rename column title to titolo--";
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if(optCon.isEmpty()){
            return;
        }
        try(Connection connection = optCon.get()) {
            String query = "select * from books where title = '" + mioTitolo + "'"; //È pericoloso aiuto
            Statement statement = connection.createStatement();
            ResultSet righeLette = statement.executeQuery(query); //executeQuery lo usiamo per le letture, quindi proprio query nel senso stretto
            while (righeLette.next()) {
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println(title.length());
                System.out.println("Libro con id: " + id + " e titolo: " + title);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
