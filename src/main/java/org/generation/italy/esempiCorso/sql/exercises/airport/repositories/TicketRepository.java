package org.generation.italy.esempiCorso.sql.exercises.airport.repositories;

import org.generation.italy.esempiCorso.sql.exercises.airport.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    Optional<Ticket> findByCode(String code);
    List<Ticket> findByPassengerId(long id);
    Ticket createForPassenger(long id);
}
