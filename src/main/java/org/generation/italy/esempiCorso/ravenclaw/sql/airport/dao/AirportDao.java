package org.generation.italy.esempiCorso.ravenclaw.sql.airport.dao;

import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Passenger;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface AirportDao {
    Optional<Ticket> getTicketByCode(String code) throws DaoException;
    List<Ticket> getAllTicketsByPassengersId(int id) throws DaoException;
    Ticket addTickets(Ticket t) throws DaoException;
    List<Passenger> getAllPassengersByTicketsBought() throws DaoException;
    boolean deletePassengersByID(int id) throws DaoException;
}
