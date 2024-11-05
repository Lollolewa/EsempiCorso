package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.aereoporto.model.PassengerData;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerDaoJbdc implements PassengerDao{

    private Connection connection;
    //injection della connessione
    public PassengerDaoJbdc(Connection connection) {
        this.connection = connection;
    }

    private static final String FIND_TICKETS_EVER_BOUGHT = """
            SELECT p.id AS passenger_id ,p.nome AS passenger_name,
                    a.id AS airport_id ,a.nome AS airport_name, num_tickets
            COUNT (t.id) AS num_tickets
            FROM passeggero AS p
            LEFT JOIN ticket AS t
            ON p.id=t.passeggero_id
            JOIN aeroporto AS a
            ON a.id=p.aeroporto_id
            GROUP BY p.id,p.nome,a.nome,a.id
            ORDER BY num_tickets DESC
            """;
    private static final String DELETE_PASSENGER = "DELETE FROM passeggero WHERE ID =?";
    public static final String FIND_BY_ID = """
            SELECT p.id as passenger_id, p.nome as passenger_name, a.id as airport_id, a.nome as airport_name
            FROM passeggero as p
            JOIN aeroporto as a
            ON a.id = p.aeroporto_id
            WHERE p.id = ?
            """;


    @Override
    public List<PassengerData> findAllOrderedByNumTickets() throws DaoException {
        //ogni passeggero ha il suo aereporto ma la lista dei biglietti è vuota
        //io mi drogo ma riccardo di piu
        //per ogni passeggero -> vedere numero biglietti
        List<PassengerData> passengers = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_EVER_BOUGHT);
            ResultSet rs = ps.executeQuery()){
            //non sono obbligata a usare Prepared, basta Statement perchè non devo settare parametri
            //resulset dentro il primo try
            //dentro il try solo creazioni di risorse autoclosable, quante ne voglio
            while(rs.next()) {
                Passenger p = new Passenger(
                        rs.getInt("passenger_id"),
                        rs.getString("passenger_name"),
                        new Airport(
                                rs.getInt("airport_id"),
                                rs.getString("airport_name"),
                                new ArrayList<Passenger>()
                        ),
                        new ArrayList<Ticket>()
                );
                PassengerData pd = new PassengerData(p,rs.getInt("num_tickets"));
                passengers.add(pd);
            }
            return passengers;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    static Passenger fromResultSet (ResultSet rs) throws SQLException {
        //SELECT p.id as passenger_id, p.nome as passenger_name, a.id as airport_id, a.nome as airport_name
        Passenger p = new Passenger(rs.getInt("passenger_id"), rs.getString("passenger_name"),
                new Airport(rs.getInt("airport_id"), rs.getString("airport_name")));
        return p;
    }



    @Override
    public boolean deletePassengerById(int id) throws DaoException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_PASSENGER)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n==1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Passenger> findById(int id) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.findById(FIND_BY_ID, PassengerDaoJbdc::fromResultSet, id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }
}
