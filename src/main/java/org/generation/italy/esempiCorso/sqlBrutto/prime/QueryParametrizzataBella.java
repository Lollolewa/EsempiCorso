package org.generation.italy.esempiCorso.sqlBrutto.prime;

import org.generation.italy.esempiCorso.sqlBrutto.DatabaseConnection;

import java.sql.*;

public class QueryParametrizzataBella {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "select * from books where title = ?";
            // prende stringa sql
            PreparedStatement ps =  connection.prepareStatement(query); // crea query che potrà essere mandata
            // dobbiamo rimpiazzare il ? (placeholder)
            // mette narnia al posto del placeholder in indice 1
            ps.setString(1, "narnia"); // 1 è primo punto interrogativo (posizione, ne posso avere tanti)

            // execute query
            ResultSet rs = ps.executeQuery(); // la query è passata in riga 10, qui non serve
            while (rs.next()) {
                int id = rs.getInt("id"); // leggi riga in quella colonna e metti lì il valore
                String title = rs.getString("title");
                System.out.println("libro con id: " + id + " dal titolo " + title);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
