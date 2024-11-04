package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.DatabaseConnection;
import org.generation.italy.esempiCorso.airportManagement.model.Passenger;

import java.sql.Connection;
import java.util.List;

public class RepositoryFactory {
    private static final String MODE = "JDBC";

    public static TicketDao getTicketDao(List<Passenger> passengers) {
        if ("IN_MEMORY".equals(MODE)) {
            return new TicketDaoInMemory(passengers);
        } else {
            Connection connection = DatabaseConnection.getConnection().orElseThrow(() ->
                    new RuntimeException("Connection failed"));
            return new TicketDaoJdbc(connection);
        }
    }

    public static PassengerDao getPassengerDao(List<Passenger> passengers) {
        if ("IN_MEMORY".equals(MODE)) {
            return new PassengerDaoInMemory(passengers);
        } else {
            Connection connection = DatabaseConnection.getConnection().orElseThrow(() ->
                    new RuntimeException("Connection failed"));
            return new PassengerDaoJdbc(connection);
        }
    }
}

