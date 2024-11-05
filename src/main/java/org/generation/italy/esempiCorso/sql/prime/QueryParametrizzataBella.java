//package org.generation.italy.esempiCorso.sql.prime;
//
//import org.generation.italy.esempiCorso.sql.DatabaseConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class QueryParametrizzataBella {
//
//    public static void main(String[] args) {
//        String mioTitolo = "Roma";
//        try(Connection connection = DatabaseConnection.getConnection()) {
//            String query = "SELECT * FROM books WHERE titolo = ? OR titolo = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, "Narnia"); //serve per cambiare il ? in stringa.
//            // come parametri prende un int(Che indica il punto interrogativo in che posizione sta (prende in considerazione solo i punti interrogativi)
//            //poi dopo la virgola, la stringa che si vuole sostituire
//            //Al posto della stringa posso usare anche una variabile
//            ps.setString(2, mioTitolo);
//            ResultSet rs = ps.executeQuery(); //non va inserita la query perchè l'abbiamo già passata in riga 12
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String title = rs.getString("titolo");
//                System.out.println("Libro con id " + id + ", titolo: " + title);
//            }
//
//        }
//        catch(SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
