package org.generation.italy.esempiCorso.sql.prime;

import org.generation.italy.esempiCorso.sql.DatabaseConnection;

import java.sql.Connection;

public class FirstConnection {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();
        if(connection != null){
            System.out.println("Connection successful!");
        }else{
            System.out.println("Connection failed");
        }






    }
}
