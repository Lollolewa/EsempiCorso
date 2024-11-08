package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.Connection.Dao.DaoException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public interface AirportDao {
    Airport create(Airport toSave) throws DaoException;
    Optional<Airport> findById (int id) throws DaoException;
    boolean update(Airport newAirport) throws DaoException;
    boolean delete(int aiportID) throws DaoException;
    List<Airport> findAll() throws DaoException;
    Optional<Airport>findByName(String name) throws DaoException;
    int getAirportCount() throws DaoException;
    List<Airport> getByPassengerCountGreater(int size) throws DaoException;
    List<Airport> byFinderPassengerName(String passengerName) throws DaoException;
    List<Objects[]> findWithPassengerCount() throws DaoException;
    List<AirportPassengerCount> bestFindByPassengerCount()throws DaoException;
    List<Airport> findWithAvgTicketPerPassengerAboveIntNumTickets(int numTickets) throws DaoException;
}
