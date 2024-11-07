package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.util.List;
import java.util.Optional;

public class AirportDaoJpa implements AirportDao{
    @Override
    public Airport create(Airport toSave) throws DaoException {
        return null;
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        return false;
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        return List.of();
    }
}
