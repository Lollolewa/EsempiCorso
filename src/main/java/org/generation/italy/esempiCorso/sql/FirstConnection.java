package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;

public class FirstConnection {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if(connection != null){
            System.out.println("connected");
        }
        else {
            System.out.println("connection failed");
        }
    }
}
