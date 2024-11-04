package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.model.Ticket;

import java.sql.*;
import java.util.Optional;

public class TicketDaoJdbc implements TicketDao {
    private Connection connection;
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
    public Optional<Ticket> getTicketByCode(String code) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ID_SQL)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery();) {
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
