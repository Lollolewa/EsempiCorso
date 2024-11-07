package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirportDaoJdbc implements AirportDao {
    private Connection connection;
    JdbcTemplate template = new JdbcTemplate(connection);

    public AirportDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    public static final String CREATE_AIRPORT = """
            INSERT INTO aeroporto (nome) VALUES (?)
             """;
    public static final String FIND_BY_ID = """
            SELECT id, nome FROM aeroporto WHERE id =?
             """;
    public static final String UPDATE_AIRPORT = """
            UPDATE aeroporto SET nome = ? WHERE id = ?
             """;
    public static final String DELETE_AIRPORT = """ 
            DELETE FROM aeroporto WHERE id =?
             """;
    public static final String FIND_ALL_AIRPORT = """
            SELECT id, nome FROM aeroporto
             """;



    @Override
    public Airport create(Airport toSave) throws DaoException {
        try {
           return template.insert(CREATE_AIRPORT, toSave, toSave.getName());
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        try {
            return template.findById(FIND_BY_ID, AirportDaoJdbc::fromResultSet, id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        try {
            int n = template.update(UPDATE_AIRPORT, newAirport.getName(), newAirport.getId());
            return n != 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        try {
            int n = template.update(DELETE_AIRPORT, airportID);
            return n == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        try {
            return template.queryForObjects(FIND_ALL_AIRPORT, AirportDaoJdbc::fromResultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
    private static Airport fromResultSet(ResultSet rs) throws SQLException { // Funzione che mappa resultSet in aeroporto
        return new Airport(rs.getInt("id"), rs.getString("name"));
    }
}
