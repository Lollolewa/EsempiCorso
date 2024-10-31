package org.generation.italy.esempiCorso.Connection.Prime;

import org.generation.italy.esempiCorso.Connection.DataBaseConnection;

import java.sql.Connection;
    public class PrimaConnessione {
        public static void main(String[] args) {
            Connection connection = DataBaseConnection.getConnection();
            if(connection != null){
                System.out.println("Connessione avvenuta con successo");
                System.out.println(connection.getClass().getName());
            } else {
                System.out.println("Connessione fallita");
            }
        }
    }

