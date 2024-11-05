package org.generation.italy.esempiCorso.sql2.dao;

import org.generation.italy.esempiCorso.sql2.model.Passengers;
import org.generation.italy.esempiCorso.sql2.model.Tickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketsDaoJdbc implements TicketsDao{
    Connection connection;
    public TicketsDaoJdbc(Connection connection){
        this.connection = connection;
    }
    @Override
    public Optional<Tickets> findTicketByCode(String code) throws DaoException {
        String query = "SELECT * FROM tickets where ticket_code = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Tickets ticket = new Tickets(
                        rs.getInt("id"),
                        rs.getString("ticket_code"),
                        rs.getInt("passenger_id")
                );
                return Optional.of(ticket);
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Tickets> showTicketsByPassengerId(int id) throws DaoException {
        List<Tickets> listOfTicketsByPassengerId = new ArrayList<>();
        String query = "SELECT * FROM tickets where passenger_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tickets tickets = new Tickets(
                        rs.getInt("id"),
                        rs.getString("ticket_code"),
                        rs.getInt("passenger_id")
                );
                listOfTicketsByPassengerId.add(tickets);
            }
            return listOfTicketsByPassengerId;
        } catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public Tickets createTicketByPassenger(int ticketId, String ticketCode, int passengerId) throws DaoException {
        String query = "INSERT INTO tickets(ticketid, ticket_code, passengerid) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ticketId);
            ps.setString(2, ticketCode);
            ps.setInt(3, passengerId);

            ps.executeUpdate();
            return new Tickets(ticketId, ticketCode, passengerId);
        } catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public void showPassengersByTickets(int minTicketCount) throws DaoException{
        String query = "SELECT p.passengerId, p.passengerName, COUNT(t.ticketId) AS ticket_count\n" +
                "            FROM passengers p\n" +
                "            JOIN tickets t ON p.passengerId = t.passengerId\n" +
                "            GROUP BY p.passengerId, p.passengerName\n" +
                "            HAVING COUNT(t.ticketId) >= ?\n" +
                "            ORDER BY ticket_count DESC";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, minTicketCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int passengerId = rs.getInt("passengerid");
                String name = rs.getString("passengername");
                int ticketCount = rs.getInt("ticket_count");

                System.out.println("ID: " + passengerId + ", Nome: " + name + ", Numero di biglietti: " + ticketCount);
            }
        } catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean deletePassengersById(int id) throws DaoException {
        String query = "DELETE FROM passenger where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Il passeggero è stato correttamente cancellato");
                return true;
            }else {
                System.out.println("Impossibile cancellare il passeggero: nessun riferimento trovato per l'ID fornito");
                return false;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }
}
