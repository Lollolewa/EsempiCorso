package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.util.List;
import java.util.Optional;

public interface TicketDao {
    Optional<Ticket> findByCode(String code) throws DaoException;
    List<Ticket> findByPassengerId(long id) throws DaoException;
    Optional<Ticket> create(Ticket ticket) throws DaoException;
}
