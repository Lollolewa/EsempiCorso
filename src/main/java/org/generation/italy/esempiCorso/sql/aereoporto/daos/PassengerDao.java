package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.model.PassengerData;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.util.List;

public interface PassengerDao {

    List<PassengerData> findAllOrderedByNumTickets() throws DaoException;
    boolean deletePassengerById(int id) throws DaoException;
}
