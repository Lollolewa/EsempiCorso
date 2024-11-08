package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.util.List;
import java.util.Optional;


public interface AirportDao {
    Airport create (Airport toSave) throws DaoException;
    Optional<Airport> findById(int id) throws DaoException;
    boolean update(Airport newAirport) throws DaoException;
    boolean delete(int airportID) throws DaoException;
    List<Airport> findAll() throws DaoException;
    Optional<Airport> findByName (String name) throws DaoException;
    int getAirportCount () throws DaoException;
    List<Airport> getByPassengerCountGreater (int size) throws DaoException;
    List<Airport> findByPassengerName (String passengerName) throws DaoException;
    List<Object[]> findWithPassengerCount () throws DaoException;
    List<AirportPassengerCount> betterFindWithPassengerCount () throws DaoException;
    List<Airport> findWithAvgTicketsPerPassengerAbove (int numTickets) throws DaoException;
}
