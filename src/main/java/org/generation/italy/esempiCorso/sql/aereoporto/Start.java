package org.generation.italy.esempiCorso.sql.aereoporto;

import org.generation.italy.esempiCorso.airport.DatabaseConnection;
import org.generation.italy.esempiCorso.airport.repository.AirportRepository;
import org.generation.italy.esempiCorso.airport.repository.AirportRepositoryJDBC;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.PassengerDao;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.PassengerDaoJbdc;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.TicketDao;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.TicketDaoJbdc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Start {
    public static void main(String[] args) throws SQLException {
        Optional<Connection> optionalConnection = DatabaseConnection.getConnection();
        if(optionalConnection.isEmpty()){
            System.out.println("Problema nella creazione della connessione.");
            return;
        }
        try (Connection connection = optionalConnection.get()){
            PassengerDao passengerDao = new PassengerDaoJbdc(connection);
            TicketDao ticketDao = new TicketDaoJbdc(connection);
            UserInterfaceVecchia ui = new UserInterfaceVecchia(connection, ticketDao, passengerDao);
            ui.begin();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
