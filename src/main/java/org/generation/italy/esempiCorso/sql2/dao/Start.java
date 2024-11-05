package org.generation.italy.esempiCorso.sql2.dao;

import org.generation.italy.esempiCorso.sql2.DatabaseConnectionA;
import org.generation.italy.esempiCorso.sql2.model.Tickets;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Start {
    public static void main(String[] args) throws DaoException {
        Optional<Connection> optCon = DatabaseConnectionA.getConnection();
        if(optCon.isEmpty()) {
            System.out.println("Problema nella creazione della connessione.");
            return;
        }
        try (Connection connection = optCon.get()) {
            TicketsDao ticketsDao = new TicketsDaoJdbc(connection);
            ticketsDao.showPassengersByTickets(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
