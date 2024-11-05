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
                                                    SELECT t.id as ticket_id, t.codice as ticket_code, p.id as passenger_id,
                                                    a.id as airport_id, a.nome as airport_name
                                                    FROM ticket as t
                                                    join passeggero as p
                                                    on t.passeggero_id = p.id
                                                    join aeroporto as a
                                                    on a.id = p.aereporto_id
                                                    where t.passeggero_id = ?
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
                if(rs.next()){
                    return Optional.of(fromResultSet(rs));
                }else{
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);
        }
    }

    private Ticket fromResultSet (ResultSet rs) throws SQLException{
            Ticket t = new Ticket(
                    rs.getInt("ticket_id"),
                    rs.getString("ticket_code"),
                    new Passenger(rs.getInt("passenger_id"), rs.getString("passenger_name"),
                            new Airport(rs.getInt("airport_id"),
                                rs.getString("airport_name"),
                                new ArrayList<Passenger>()),
                            new ArrayList<Ticket>())
                    );
            return t;
    }

    @Override
    public List<Ticket> findByPassengerId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_FOR_PASSENGER)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Ticket t = fromResultSet(rs);
                    tickets.add(t);
                }
                return tickets;
            }
        } catch (SQLException e) {
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Ticket createTicket(Ticket t) throws DaoException {

        try (PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TICKET,
             PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getCode());
            ps.setInt(2, t.getPassenger().getId());

            ps.executeUpdate();

            try(ResultSet genKeys = ps.getGeneratedKeys()){
                if(genKeys.next()){
                    int id = genKeys.getInt(1);
                    t.setId(id);
;               }
            }
            return t;

        } catch (SQLException e) {
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);
        }
    }
//    //somma due numeri se glie li passo negativi diventano positivi e li somma lo stesso
//    public int sum (int x, int y){
////        if (x < 0){
////            x = -x;
////        }
//        if(y < 0){
//            y = -y;
//        }
//        return x + y;
//    }
}
