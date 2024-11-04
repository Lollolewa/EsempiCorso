package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.model.Ticket;

import java.util.Optional;

public interface TicketDao {
    Optional<Ticket> getTicketByCode(String code) throws DaoException;
    Ticket addTicketToPsg(String code, int id) throws DaoException;
}
