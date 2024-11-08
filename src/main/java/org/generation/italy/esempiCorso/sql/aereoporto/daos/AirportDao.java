package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.Connection.Dao.DaoException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.util.List;
import java.util.Optional;


public interface AirportDao {
    Airport create(Airport toSave) throws DaoException;
    Optional<Airport> findById (int id) throws DaoException;
    boolean update(Airport newAirport) throws DaoException;
    boolean delete(int aiportID) throws DaoException;
    List<Airport> findAll() throws DaoException;


}
