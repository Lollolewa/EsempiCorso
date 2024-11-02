package org.generation.italy.esempiCorso.sql.aereoporto;

import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.util.List;
import java.util.Optional;

public interface AirportDao {

    Optional<Ticket> findTicket(String code);
    List<Ticket> findTicketByIdPassenger(int id);
    Optional<Ticket> createTicket(Ticket t);
    List<Passenger> showNumTicketsForPassenger();
    void deletePassenger(int id) throws DaoException;
}
