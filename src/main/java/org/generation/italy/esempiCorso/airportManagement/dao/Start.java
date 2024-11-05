package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.DatabaseConnection;
import org.generation.italy.esempiCorso.airportManagement.entity.Passenger;
import org.generation.italy.esempiCorso.airportManagement.entity.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        List<Passenger> passengers = DataInitializer.initializePassengers(tickets);
        tickets = DataInitializer.initializeTickets(passengers);

        TicketDao ticketDao = RepositoryFactory.getTicketDao(passengers);
        PassengerDao psgDao = RepositoryFactory.getPassengerDao(passengers);

        Optional<Connection> optConn = DatabaseConnection.getConnection(); // stabilisce connessione (optional)
        if (optConn.isEmpty()) {
            System.out.println("Error creating connection to the database.");
            return;
        }

        try (Connection connection = optConn.get()) {
            // Find ticket by id
            Optional<Ticket> optTick = ticketDao.getTicketByCode("TICKET002");
            if (optTick.isPresent()) {
                System.out.println(optTick.get());
            } else {
                System.out.println("Ticket not found.");
            }

            // Find all tickets of a passenger by id
            List<Ticket> psgTickets = psgDao.getPsgTicketsById(1);
            System.out.println("Tickets from passenger id 1");
            System.out.println(psgTickets);

            // Add ticket to psg
            Ticket addedTicket = ticketDao.addTicketToPsg("TICKET013", 4);
            System.out.println("Ticket added:");
            System.out.println(addedTicket);

            // Print passengers ordered by number of tickets
            psgDao.printPsgByNumTickets();

            // Delete by id
            if (psgDao.deleteById(2)) {
                System.out.println("Passenger has been correctly removed.");
            } else {
                System.out.println("id couldn't be found");
            }
        } catch (DaoException | SQLException e) {
            e.printStackTrace();
        }
    }
}