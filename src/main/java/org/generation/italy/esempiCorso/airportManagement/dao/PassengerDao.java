package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.model.Ticket;

import java.util.List;

public interface PassengerDao {
    List<Ticket> getPsgTicketsById(int id) throws DaoException; // se non ci sono restituisce lista vuota ??? ma che ci fa qui?? dà ticket...
    void printPsgByNumTickets() throws DaoException;
    boolean deleteById(int id) throws DaoException;
}
