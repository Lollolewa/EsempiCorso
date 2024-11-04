package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoJdbc implements PassengerDao {
    private Connection connection;
    private final static String SELECT_SQL = """
            select * from tickets
            where psgid = ?;
            """;
    private static final String SELECT_TICKETS_SQL = """
            select p.psgid, p.firstname, p.lastname, count(t.tickid) as ticket_count
            from passengers as p
            left join tickets as t
            using (psgid)
            group by p.psgid, p.firstname, p.lastname
            order by ticket_count
            """;
//    private static final String SELECT_TICKETS_SQL = """
//            select p.psgid, p.firstname, p.lastname, a.name, count(t.tickid) as ticket_count
//            from passengers as p
//            left join tickets as t
//            using (psgid)
    //        join airports as a
    //        using (airpid)
//            group by p.psgid, p.firstname, p.lastname, a.airpid
//            order by ticket_count
//            """;
    private static final String DELETE_SQL = """
            delete from passengers
            where psgid = ?
            """;

    public PassengerDaoJdbc(Connection connection) {
        this.connection = connection; // injection of connection in the constructor of DAO
    }

    @Override
    public List<Ticket> getPsgTicketsById(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Ticket ticket = new Ticket(
                            rs.getInt("tickid"),
                            rs.getString("code"),
                            rs.getInt(("psgid"))
                    );
                    tickets.add(ticket);
                }
                return tickets;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void printPsgByNumTickets() throws DaoException { //pb delle n + 1 query
        try (PreparedStatement ps = connection.prepareStatement(SELECT_TICKETS_SQL); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                System.out.printf("psgid: %d, %s %s, ticket counts: %d%n",
                        rs.getInt("psgid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("ticket_count")
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
