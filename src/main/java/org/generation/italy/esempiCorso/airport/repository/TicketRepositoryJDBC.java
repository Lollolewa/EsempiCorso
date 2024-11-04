package org.generation.italy.esempiCorso.airport.repository;

import org.generation.italy.esempiCorso.airport.model.Airport;
import org.generation.italy.esempiCorso.airport.model.Passenger;
import org.generation.italy.esempiCorso.airport.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketRepositoryJDBC implements TicketRepository{
    Connection connection;

    private final static String GET_TICKET_CODE_SQL = """
        select code, passenger_id from ticket where code = ?
        """;
    private final static String GET_PASSENGER_TICKETS = """
        select ticket_id, code, passenger_id from ticket where passenger_id = ?
        """;
    private final static String INSERT_NEW_PASSENGER_TICKET = """
        insert into ticket (code, passenger_id)
        values (?,?)
        """;


    public TicketRepositoryJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public Optional<Ticket> searchTicketByCode(String code) throws SQLException {
        Optional<Ticket> searchedTicket = Optional.empty();
        try(PreparedStatement ps = connection.prepareStatement(GET_TICKET_CODE_SQL)) {
            ps.setString(1, code);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
//                    Ticket ticket = new Ticket(
//                            rs.getString("code"),
//                            rs.getInt("passenger_id")
//                    );
//                    searchedTicket = Optional.of(ticket);
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
        return searchedTicket;
    }

    @Override
    public List<Ticket> getPassengersTikets(int passengerID) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_PASSENGER_TICKETS)) {
            ps.setInt(1, passengerID);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    //Ticket ticket = new Ticket(
                            //rs.getString("code"),
                            //rs.getInt("passenger_id")
                    //);
                    //ticket.setId(rs.getLong("ticket_id")); // Imposta l'ID generato
                    //tickets.add(ticket);
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
        return tickets;
    }

    @Override
    public Ticket createNewPassengerTicket(String code, int passengerID) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_NEW_PASSENGER_TICKET)) {
            ps.setString(1, code);
            ps.setInt(2, passengerID);
            Ticket ticket = new Ticket(code, passengerID, new Passenger("","",new Airport(1,"", new ArrayList<Passenger>())));
            ps.executeUpdate();
            return ticket;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
    }
}
