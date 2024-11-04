package org.generation.italy.esempiCorso.airport.repository;

import org.generation.italy.esempiCorso.airport.model.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PassengerRepositoryJDBC implements PassengerRepository{
    Connection connection;
    private final static String GET_NUM_TICKETS_ALL_PASSENGERS = """
        select p.passenger_id, p.name, p.surname, p.airport_id, count(t.ticket_id) as ticket_count
        from passenger p
        left join ticket t on p.passenger_id = t.passenger_id
        group by p.passenger_id, p.name, p.surname, p.airport_id
        order by ticket_count desc
        """;
    private final static String DELETE_PASSENGER_BY_ID = """
        delete from passenger where passenger_id = ?;
        """;
    //--delete from ticket where passenger_id = ?; usando cascade posso non metterlo

    public PassengerRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PassangerData> findAllOrderByNumTickets() throws SQLException {
        List<PassangerData> passNumTicket = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_NUM_TICKETS_ALL_PASSENGERS); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    //String passengerName, String passengerSurname, int airportID
                    Passenger passenger = new Passenger(
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("airport_id"));
                    passenger.setId(rs.getLong("passenger_id")); // Imposta l'ID generato
                    int ticketCount = rs.getInt("ticket_count");
                    passNumTicket.put(passenger, ticketCount);
                }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
        return passNumTicket;
    }

    @Override
    public boolean deletePassengerByID(int id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_PASSENGER_BY_ID)) {
            ps.setInt(1, id);
            //ps.setInt(2, id);
            int update = ps.executeUpdate();
            return update != 0;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        }
    }
}
