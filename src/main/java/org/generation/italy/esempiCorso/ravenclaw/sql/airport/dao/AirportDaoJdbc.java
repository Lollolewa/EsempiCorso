package org.generation.italy.esempiCorso.ravenclaw.sql.airport.dao;

import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Passenger;
import org.generation.italy.esempiCorso.ravenclaw.sql.airport.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportDaoJdbc implements AirportDao{
    Connection connection;
    private static final String GETTICKET_SQL = """
            select * from tickets where code = ?;
            """;
    private static final String GETALLTICKETS_SQL = """
            select * from tickets where passenger_id = ?;
            """;
    private static final String INSERTTICKET_SQL = """
            insert into tickets(code,passenger_id)
            values(?,?)
            """;
    public static final String GETALLPASSBYTICKETSBOUGHT_SQL = """
            SELECT p.name, COUNT(*) as ticket_counts
            from passengers as p join tickets as t
            on p.id = t.passenger_id
            group by p.name
            order by ticket_counts desc
            """;
    private static final String DELETE_PASSENGER_SQL = """
    DELETE FROM passengers WHERE id =?
    """;

    public AirportDaoJdbc(Connection connection) {this.connection = connection;}

    @Override
    public Optional<Ticket> getTicketByCode(String code) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(GETTICKET_SQL)){
            ps.setString(1,code);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Ticket t = new Ticket(
                            rs.getString("code"),
                            rs.getInt("id"),
                            rs.getInt("passenger_id")
                    );
                    return Optional.of(t);
                }
                return Optional.empty();
            }
        }catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Ticket> getAllTicketsByPassengersId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(GETTICKET_SQL)){
         try(ResultSet rs = ps.executeQuery()){
             while(rs.next()){
                 Ticket ticket = new Ticket(
                         rs.getString("code"),
                         rs.getInt("id"),
                         rs.getInt("passenger_id")
                 );
                 tickets.add(ticket);
             }return tickets;
         }
        }catch(SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public Ticket addTickets(Ticket t) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(INSERTTICKET_SQL)){
            ps.setString(1,t.getCode());
            ps.setInt(2, t.getPassenger_id());
            ps.executeUpdate();
            return t;
        }catch(SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Passenger> getAllPassengersByTicketsBought() throws DaoException {
       List<Passenger> passengers = new ArrayList<>();
       try(PreparedStatement ps = connection.prepareStatement(GETALLPASSBYTICKETSBOUGHT_SQL)){
           try(ResultSet rs = ps.executeQuery()){
               while(rs.next()){
                   Passenger p = new Passenger(
                           rs.getString("name"),
                           rs.getString("surname"),
                           rs.getInt("id"),
                           rs.getInt("airport_id")
                   );
                   passengers.add(p);
               } return passengers;
           }
       }catch(SQLException e){
           throw new DaoException(e.getMessage(),e);
       }
    }

    @Override
    public boolean deletePassengersByID(int id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_PASSENGER_SQL)){
            ps.setInt(1,id);
            int n = ps.executeUpdate();
            return n == 1;
        }catch(SQLException e){
            throw new DaoException(e.getMessage(),e);
        }
    }
}
