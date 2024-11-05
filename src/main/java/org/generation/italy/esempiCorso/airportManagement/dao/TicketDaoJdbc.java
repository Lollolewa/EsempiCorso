package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.entity.Ticket;

import java.sql.*;
import java.util.Optional;

public class TicketDaoJdbc implements TicketDao {
    private Connection connection;

    private static final String FIND_TICKET_BY_CODE = """
            select t.tickid as ticket_id,
                t.code as ticket_code,
                p.psgid as passenger_id,
                a.airpid as airport_id,
                a.name as airport_name
            from tickets as t
            left join passengers as p
            using (tickid)
            join airports as a
            using(airpid)
            where t.code = ?;
            """;
    private static final String CREATE_NEW_TICKET = """
            INSERT INTO tickets (codice, passeggero_id)
            values(?,?)
            """;

    private static final String SELECT_ID_SQL = """
            select * from tickets
            where code = ?;
            """;
    private final static String INSERT_SQL = """
            insert into tickets(code, psgid)
            values (?, ?);
            """;

    public TicketDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Ticket> findByCode(String code) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKET_BY_CODE)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ticket ticket = new Ticket(
                            rs.getInt("tickid"),
                            rs.getString("code"),
                            rs.getInt("psgid")
                    );
                    return Optional.of(ticket);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Ticket addTicketToPsg(String code, int psgid) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, code);
            ps.setInt(2, psgid);
            if (ps.executeUpdate() == 0) {
                throw new DaoException("Creation failed.");
            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt("tickid");
                    return new Ticket(id, code, psgid);
                } else {
                    throw new DaoException("no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
