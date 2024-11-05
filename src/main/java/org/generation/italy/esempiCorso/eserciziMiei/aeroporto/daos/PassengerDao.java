package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Passeggero;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.model.PassengerData;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.util.List;

public interface PassengerDao {
    List<PassengerData> findAllOrderedByNumTickets() throws DaoException, org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos.DaoException;
    boolean removeById(long id) throws DaoException, org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos.DaoException;
}
