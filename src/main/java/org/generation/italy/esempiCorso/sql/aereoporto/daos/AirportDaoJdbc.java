package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirportDaoJdbc implements AirportDao {
    private Connection connection;

    public static final String FIND_BY_ID = """
                                            SELECT id,nome FROM aeroporto WHERE id=?
                                            """;
    public static final String INSERT_SQL = """
                                            INSERT in to aeroporto (id,name)
                                            value(?,?)
                                            """;
    public static final String UPDATE_SQL = """
                                            UPDATE aeroporto
                                            SET nome=?
                                            WHERE id=?
                                            """;
    public static final String DELETE_SQL = """
                                            DELETE FROM aeroporto
                                            WHERE id=?
                                            """;
    public static final String SELECT_ALL_SQL = """
                                                SELECT id,nome
                                                FROM aeroporto
                                                """;
    public AirportDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Airport create(Airport toSave) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try{
            return template.insert(INSERT_SQL,toSave,toSave.getId(),toSave.getName());
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.findById(FIND_BY_ID, AirportDaoJdbc::fromResultSet, id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.update(UPDATE_SQL,newAirport.getName(),newAirport.getId()) ==1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.update(DELETE_SQL,airportID) ==1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.queryForObjects(SELECT_ALL_SQL,AirportDaoJdbc::fromResultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findByName(String name) throws DaoException {
        return Optional.empty();
    }

    @Override
    public int getAirportCount() throws DaoException {
        return 0;
    }

    @Override
    public List<Airport> getByPassengerCountGreater(int size) throws DaoException {
        return List.of();
    }

    @Override
    public List<Airport> findByPassengerName(String passengerName) throws DaoException {
        return List.of();
    }

    @Override
    public List<Object[]> findWithPassengerCount() throws DaoException {
        return List.of();
    }

    @Override
    public List<AirportPassengerCount> betterFindWithPassengerCount() throws DaoException {
        return List.of();
    }

    @Override
    public List<Airport> findWithAvgTicketsPerPassengerAbove(int numTickets) throws DaoException {
        return List.of();
    }

    static Airport fromResultSet(ResultSet rs) throws SQLException{
        return new Airport(rs.getInt("id"),rs.getString("nome"));
    }
}