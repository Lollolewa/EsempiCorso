package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;

public class PrimaConnessione {
    public static void main(String[] args) {
        Connection connection = DataBaseConnection.getConnection();
        if(connection != null){
            System.out.println("Connessione riuscita");
        }else
            System.out.println("connessione fallita");
    }
}
