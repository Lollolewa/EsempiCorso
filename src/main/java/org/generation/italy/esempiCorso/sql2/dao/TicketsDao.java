package org.generation.italy.esempiCorso.sql2.dao;

import org.generation.italy.esempiCorso.sql2.model.Passengers;
import org.generation.italy.esempiCorso.sql2.model.Tickets;

import java.util.List;
import java.util.Optional;

public interface TicketsDao {
    Optional<Tickets> findTicketByCode(String code) throws DaoException;
    List<Tickets> showTicketsByPassengerId(int id) throws DaoException;
    Tickets createTicketByPassenger(int ticketId, String ticketCode,int passengerId) throws DaoException;
    void showPassengersByTickets(int minTicketCount) throws DaoException;
    boolean deletePassengersById(int id) throws DaoException;

}
