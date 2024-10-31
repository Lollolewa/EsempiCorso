package org.generation.italy.esempiCorso.Connection.Prime;

import org.generation.italy.esempiCorso.Connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryparametrizzataBrutta {
    public static void main(String[] args) {
        String mioTitolo = "La giungla";
       // String mioTitolo = "La giungla'; alter table books rename column title to titolo--";
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "select * from books where title = '" + mioTitolo + "'"; //metodo che prende come parametro una stringa e lo mette dentro le '' per poterla passare al database
            Statement st = connection.createStatement(); //restituisce un oggetto statement che permette di eseguire delle query
            ResultSet righeLette = st.executeQuery(query); //esegue la query, lo usiamo per le letture
            while (righeLette.next()) {
                int id = righeLette.getInt("id");
                String title = righeLette.getString("title");
                System.out.println("libro con id: " + id + " con titolo " + title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
