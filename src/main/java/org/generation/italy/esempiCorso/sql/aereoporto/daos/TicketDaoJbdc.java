package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoJbdc implements TicketDao{

    private static final String CREATE_NEW_TICKET = "INSERT INTO tickets (codice, passeggero_id) values(?,?)";
    private static final String FIND_TICKET_BY_CODE = """
                                                    SELECT t.id AS ticket_id,t.codice AS ticket_code, p.id AS passenger_id,
                                                           a.id AS airport_id, a.nome AS airport_name
                                                    FROM ticket AS t
                                                    JOIN passeggero AS p
                                                    ON t.passeggero_id=p.id
                                                    JOIN aeroporto AS a
                                                    ON a.id = p.aereoporto_id
                                                    WHERE code=?
                                                    """;
    private static final String FIND_TICKETS_FOR_PASSENGER = """
                                                    SELECT t.id as ticket_id, t.code as code, p.id as passenger_id, p.nome as passenger_name,
                                                    a.id AS airport_id, a.nome AS airport_name
                                                    FROM ticket JOIN passeggero AS p
                                                    ON t.passeggero_id=p.id
                                                    JOIN aeroporto AS a
                                                    ON a.id = p.aereoporto_id
                                                    WHERE passeggero_id = ?
                                                    """;
    private Connection connection;

    public TicketDaoJbdc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Ticket> findByCode(String code) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKET_BY_CODE)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ticket t = new Ticket(
                            rs.getInt("ticket_id"),
                            rs.getString("ticket_code"),
                            new Passenger(rs.getInt("passenger_id"),rs.getString("passenger_name"),
                                    new Airport(rs.getInt("airport_id"),
                                                rs.getString("airport_name"),
                                                new ArrayList<Passenger>()),
                                    new ArrayList<Ticket>())
                    );
                    return Optional.of(t);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Ticket> findByPassengerId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_FOR_PASSENGER)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Ticket t = new Ticket(
                            rs.getInt("ticket_id"),
                            rs.getString("code"),
                            new Passenger(rs.getInt("passenger_id"),
                                    rs.getString("passenger_name"),
                                    new Airport(rs.getInt("airport_id"),
                                            rs.getString("airport_name"),
                                            new ArrayList<Passenger>()), new ArrayList<>()));
                    tickets.add(t);
                }
                return tickets;
            }
        } catch (SQLException e) {
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Ticket createNewPassengerTicket(Ticket ticket) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TICKET)) {
            ps.setString(1, ticket.getCode());
            ps.setInt(2, ticket.getPassenger().getId());
            ps.executeUpdate();
            return ticket;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
    }
}
