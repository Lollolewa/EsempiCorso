package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class QueryParametrizzataBella {
        public static void main(String[] args) {
            try(Connection conn = DatabaseConnection.getConnection()){
                String query = "select * from books where title = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "Narnia");
                ResultSet rs = pstmt.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt("id");
                    String titolo = rs.getString("title");
                    System.out.println("ID: " + id + ", Titolo: " + titolo);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
