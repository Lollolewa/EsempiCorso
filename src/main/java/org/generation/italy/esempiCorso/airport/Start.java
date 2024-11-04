package org.generation.italy.esempiCorso.airport;
import org.generation.italy.esempiCorso.airport.repository.AirportRepository;
import org.generation.italy.esempiCorso.airport.repository.AirportRepositoryJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;


public class Start {
    public static void main(String[] args) {
        Optional<Connection> optionalConnection = DatabaseConnection.getConnection();
        if(optionalConnection.isEmpty()){
            System.out.println("Problema nella creazione della connessione.");
            return;
        }
        try (Connection connection = optionalConnection.get()){
            AirportRepository airportRepository = new AirportRepositoryJDBC(connection);
            UserInterface ui = new UserInterface(connection, airportRepository);
            ui.begin();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
