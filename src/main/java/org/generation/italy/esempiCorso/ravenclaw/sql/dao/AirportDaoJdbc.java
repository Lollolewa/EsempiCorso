package org.generation.italy.esempiCorso.ravenclaw.sql.dao;

import org.generation.italy.esempiCorso.ravenclaw.sql.model.Passenger;
import org.generation.italy.esempiCorso.ravenclaw.sql.model.Ticket;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AirportDaoJdbc implements AirportDao{
    Connection connection;

    public AirportDaoJdbc(Connection connection) {this.connection = connection;}

    @Override
    public Optional<Ticket> getTicketByCode(String code) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Ticket> getAllTicketsByPassengersId(int id) throws DaoException {
        return List.of();
    }

    @Override
    public Ticket addTickets(Ticket t) throws DaoException {
        return null;
    }

    @Override
    public List<Passenger> getAllPassengersByTicketsBought() throws DaoException {
        return List.of();
    }

    @Override
    public boolean deletePassengersByID(int id) throws DaoException {
        return false;
    }
}
