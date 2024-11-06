package org.generation.italy.esempiCorso.ravenclaw.sql.airport.dao;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Passengers;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Tickets;
import java.util.List;
import java.util.Optional;

public interface AirportsDao {
    Optional<Tickets> getTicketByCode(String code) throws DaoException;
    List<Tickets> getAllTicketsByPassengersId(int id) throws DaoException;
    Tickets addTickets(Tickets t) throws DaoException;
    List<Passengers> getAllPassengersByTicketsBought() throws DaoException;
    boolean deletePassengersByID(int id) throws DaoException;
}