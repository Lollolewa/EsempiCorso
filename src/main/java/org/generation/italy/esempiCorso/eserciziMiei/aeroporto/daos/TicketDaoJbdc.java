package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Aeroporto;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Passeggero;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoJbdc implements TicketDao{
    private Connection connection;

    public TicketDaoJbdc(Connection connection) {
        this.connection = connection;
    }

    // creo le stringhe SQL
    private static final String GET_TICKET_BY_CODE = """
            SELECT t.id AS ticket_id, t.code AS ticket_code, p.id AS passenger_id,
            a.id AS airport_id, a.name AS airport_name
            FROM tickets AS t
            JOIN passengers AS p
            ON t.passenger_id = p.id
            JOIN aeroporto AS a
            ON a.id = p.airport_id
            WHERE code = ?
            """;
    private static final String GET_PASSENGER_TICKET_BY_ID = """
            select *
            from tickets
            where passenger_id = ?
            """;
    private static final String CREATE_TICKET = """
            insert into tickets
            (code, passenger_id)
            values
            (?, ?)
            """;

    @Override
    public Optional<Ticket> findByCode(String code) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(GET_TICKET_BY_CODE)){
            ps.setString(1, code);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(fromResultSet(rs));
                } else{
                    return Optional.empty();
                }
            }
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    private Ticket fromResultSet(ResultSet rs) throws SQLException{
        Ticket ticket = new Ticket(
                    rs.getLong("ticket_id"),
                    rs.getString("ticket_code"),
                    new Passeggero(rs.getLong("passenger_id"),
                            rs.getString("passenger_name"),
                            rs.getString("passenger_surname"),
                            new Aeroporto(rs.getLong("airport_id"),
                                    rs.getString("airport_name"),
                                    new ArrayList<Passeggero>()),
                            new ArrayList<Ticket>())
        );
        return ticket;
    }


    @Override
    public List<Ticket> findByPassengerId(long id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GET_PASSENGER_TICKET_BY_ID)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ticket t = fromResultSet(rs);
                //aggiungo il ticket alla lista di tickets
                tickets.add(t);
            }
            return tickets;
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Ticket> create(Ticket ticket) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_TICKET,
                PreparedStatement.RETURN_GENERATED_KEYS)){
            //assegno il code e l'id dentro il ticket dato
            ps.setString(1, ticket.getCode());
            ps.setLong(2, ticket.getPassenger().getId());

            ps.executeUpdate(); // verifico che sia stato creato
            try(ResultSet genKeys = ps.getGeneratedKeys()){
                if(genKeys.next()){
                    long id = genKeys.getLong(1);
                    ticket.setId(id);
                }
                return Optional.of(ticket);
            }
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    public int sum(int x, int y){
        if(x<0){
            x = -x;
        }
        if(y<0){
            y = -y;
        }
        return x+y;
    }

}
