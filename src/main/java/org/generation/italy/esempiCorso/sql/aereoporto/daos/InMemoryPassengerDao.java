package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.model.PassengerData;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.util.List;
import java.util.Optional;

public class InMemoryPassengerDao implements PassengerDao{
    @Override
    public List<PassengerData> findAllOrderedByNumTickets() throws DaoException {
        return List.of();
    }

    @Override
    public boolean deletePassengerById(int id) throws DaoException {
        return false;
    }

    @Override
    public Optional<Passenger> findById(int id) throws DaoException {
        return Optional.empty();
    }
}
