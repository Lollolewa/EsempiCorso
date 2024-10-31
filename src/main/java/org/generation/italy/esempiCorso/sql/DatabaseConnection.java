package org.generation.italy.esempiCorso.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnection {

    public static Optional<Connection> getConnection(){
        String jdbcUrl = "jdbc:postgresql://localhost:5432/library"; //la versione più bruttina
        String username = "postgresMaster";
        String password = "goPostgresGo";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return Optional.of(connection);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Non mi posso collegare al db :("); //per db si intende database
            return Optional.empty();
        }
    }
}


























//    public static Connection getConnection() {
//        String jdbcUrl = "jdbc:postgresql://localhost:5432/library"; //versione più bruttina
//        //jdbc = Java Databasse Connectivity
//        String username = "postgresMaster";
//        String password = "goPostgresGo";
//
//        Connection connection = null;
//        //Connection è un oggetto, da immaginare come un tubo che collega il nostro codice al database. Manderemo da java degli oggetti, che trasportano
//        //le query, e il database ci restituirà altri oggetti che contengono le informazioni richieste nelle query.
//
//        try {
//            connection = DriverManager.getConnection(jdbcUrl, username, password); //il metodo getConnection può ritornare un'eccezione
//
//        }
//        catch(SQLException e) {
//            e.printStackTrace();
//            System.out.println("Non mi posso collegare al DB");
//        }
//
//        return connection;
//    }
//}
