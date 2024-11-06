package org.generation.italy.esempiCorso.sql.exerciseAirport.repositories;

import org.generation.italy.esempiCorso.sql.exerciseAirport.model.Ticket;

import java.util.List;
import java.util.Optional;

public class JdbcPassengerRepository implements TicketRepository{
    public static final String TICKETS_BY_CODE = """
            select t.id, t.code, 
            from tickets as t join passengers as p,
            on t.passenger_id = passenger.id
            
            """;
    @Override
    public Optional<Ticket> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public List<Ticket> findByPassengerId(long id) {
        return List.of();
    }

    @Override
    public Ticket createForPassenger(long id) {
        return null;
    }
}
