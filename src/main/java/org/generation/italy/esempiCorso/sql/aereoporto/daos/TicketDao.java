package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDao {

    Optional<Ticket> findByCode(String code) throws DaoException;
    List<Ticket> findByPassengerId(int id) throws DaoException;
    Ticket createTicket(Ticket t) throws DaoException;
    Optional<Ticket> findById(int id) throws DaoException;
    List<Ticket> findByCodeLike(String code) throws DaoException;
    List<Ticket> findByAirportId(int airportId) throws DaoException;
}
