package org.generation.italy.esempiCorso.sql.aereoporto;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportDaoJbdc implements AirportDao {
    Connection connection;
    private static final String FIND_TICKET_BY_CODE = "select * from ticket where code=?";
    private static final String FIND_TICKETS_FOR_PASSENGER =
            "SELECT * FROM ticket WHERE passeggero_id = ?";
    private static final String CREATE_NEW_TICKET = "INSERT INTO tickets (id, codice, passeggero_id) values(?,?,?)";
    private static final String FIND_TICKETS_EVER_BOUGHT = """
            SELECT p.id,p.nome,
            COUNT (*) AS numero_biglietti
            FROM passeggero AS p
            JOIN ticket AS t
            ON p.id=t.passeggero_id
            GROUP BY p.id
            ORDER BY numero_biglietti DESC
            """;
    private static final String DELETE_PASSENGER = "DELETE FROM PASSENGER WHERE ID =?";

    public AirportDaoJbdc(Connection connection) {
        this.connection = connection;
    }

//    @Override
//    public Optional<Ticket> findTicket(String code) {
//
//        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKET_BY_CODE)) {
//            ps.setString(1, code);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    Ticket t = new Ticket(
//                            rs.getInt("id"),
//                            rs.getString("code"),
//                            rs.getInt("passeggero_id")
//                    );
//                    return Optional.of(t);
//                }
//                return Optional.empty();
//            }
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }

//    @Override
//    public List<Ticket> findTicketByIdPassenger(int id) {
//        List<Ticket> tickets = new ArrayList<>();
//        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_FOR_PASSENGER)) {
//            ps.setInt(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    Ticket t = new Ticket(
//                            rs.getInt("id"),
//                            rs.getString("code"),
//                            rs.getInt("passeggero_id")
//                    );
//                    tickets.add(t);
//                }
//                return tickets;
//            }
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }

//    @Override
//    public Optional<Ticket> createTicket(Ticket t) {
//        try (PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TICKET)) {
//            ps.setInt(1, t.getId());
//            ps.setString(2, t.getCode());
//            ps.setInt(3, t.getPasseggero_id());
//
//            int ticketAggiunto = ps.executeUpdate();
//            return ticketAggiunto > 0 ? Optional.of(t) : Optional.empty();
//
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }
    //male
    //antipattern basico -> n+1 query
//    @Override
//    public List<Passenger> showNumTicketsForPassenger() {
//        List<Passenger> listaPasseggeri = new ArrayList<>();
//        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_EVER_BOUGHT)) {
//            try (ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    int passeggero_id = rs.getInt("id");
//                    List<Ticket> tickets = findTicketByIdPassenger(passeggero_id);
//                    Passenger p = new Passenger(
//                            passeggero_id,
//                            rs.getString("nome"),
//                            rs.getInt("aereoporto_id"),
//                            tickets
//                    );
//                    listaPasseggeri.add(p);
//                }
//                return listaPasseggeri;
//            }
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }

//    @Override
//    public void deletePassenger(int id) throws DaoException {
//        try (PreparedStatement ps = connection.prepareStatement(DELETE_PASSENGER)) {
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new DaoException(e.getMessage(), e);
//        }
//    }
}