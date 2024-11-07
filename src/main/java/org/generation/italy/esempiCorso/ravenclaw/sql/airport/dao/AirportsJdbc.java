package org.generation.italy.esempiCorso.ravenclaw.sql.airport.dao;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Passengers;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Tickets;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AirportsJdbc implements AirportsDao{
    Connection connection;

    private static final String GET_TICKET_SQL = """
    SELECT * FROM tickets WHERE code = ?
    """;

    private static final String GET_ALL_TICKETS_SQL = """
    SELECT * FROM tickets WHERE passenger_id = ?
    """;

    private static final String ADD_TICKET_SQL = """
    INSERT INTO tickets (passenger_id, code) VALUES (?,?)
    RETURNING id
    """;

    private static final String GET_PASSENGERS_SQL = """
    SELECT p.name, count(*) FROM passengers as p join tickets as t
    where p.id = t.passenger_id
    group by p.name desc;
    """;

    private static final String DELETE_PASSENGER_SQL = """
    DELETE * FROM passengers WHERE id =?
    """;

    @Override
    public Optional<Tickets> getTicketByCode(String code) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Tickets> getAllTicketsByPassengersId(int id) throws DaoException {
        return List.of();
    }

    @Override
    public Tickets addTickets(Tickets t) throws DaoException {
        return null;
    }

    @Override
    public List<Passengers> getAllPassengersByTicketsBought() throws DaoException {
        return List.of();
    }

    @Override
    public boolean deletePassengersByID(int id) throws DaoException {
        return false;
    }
}
