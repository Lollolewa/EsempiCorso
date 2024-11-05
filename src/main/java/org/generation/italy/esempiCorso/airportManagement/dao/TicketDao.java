package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDao {
    Optional<Ticket> findByCode(String code) throws DaoException;
    Ticket addTicketToPsg(String code, int id) throws DaoException;
    List<Ticket> findByPassengerId(int id) throws DaoException;
}
