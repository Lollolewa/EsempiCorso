package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Aeroporto;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Passeggero;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Ticket;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.model.PassengerData;
import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoJbdc implements PassengerDao{
    private Connection connection;
    //Injection della connessione nel Dao
    public PassengerDaoJbdc(Connection connection) {
        this.connection = connection;
    }

    private static final String FIND_ALL_ORDERED_BY_NUM_TICKETS = """
            SELECT p.id AS passenger_id, p.name AS passenger_name, p.surname AS passenger_surname, a.id AS airport_id, a.name AS airport_name,
            COUNT (t.id) AS num_tickets
            FROM passengers AS p
            LEFT JOIN tickets AS t
            ON p.id = t.passenger_id
            JOIN airports AS a
            ON a.id = p.airport_id
            GROUP BY p.id, p.name, p.surname
            ORDER BY ticket_count DESC
            """;
    private static final String REMOVE_PASSENGER_BY_ID = """
            delete from passengers
            where id = ?
            """;

    @Override
    public List<PassengerData> findAllOrderedByNumTickets() throws DaoException{
        List<PassengerData> passengers = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ALL_ORDERED_BY_NUM_TICKETS);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Passeggero p = new Passeggero(
                        rs.getInt("passenger_id"),
                        rs.getString("passenger_name"),
                        rs.getString("passenger_surname"),
                        new Aeroporto(
                                rs.getInt("airport_id"),
                                rs.getString("airport_name"),
                                new ArrayList<Passeggero>()
                        ),
                        new ArrayList<Ticket>()
                );
                PassengerData pd = new PassengerData(p, rs.getInt("num_tickets"));
                passengers.add(pd);
            }
            return passengers;
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }

    }

    @Override
    public boolean removeById(long id) throws DaoException {
        try(PreparedStatement ps = connection.prepareStatement(REMOVE_PASSENGER_BY_ID)){
            ps.setLong(1, id);
            int n = ps.executeUpdate();
            return n == 1; // tornerà true se l'execute tornerà 1 il che vuol dire che è andato a buon fine
        } catch(SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }
}
