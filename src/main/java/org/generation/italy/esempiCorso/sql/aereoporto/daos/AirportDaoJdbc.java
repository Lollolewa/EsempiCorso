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
    private JdbcTemplate template;
    public final static String FIND_BY_ID = """
            SELECT id, nome
            FROM aeroporto
            WHERE id = ?;
            """;
    public final static String CREATE = """
            INSERT INTO aeroporto (id, nome)
            VALUES (?, ?);
            """;
    public static final String UPDATE = """
            UPDATE aeroporto
            SET nome = ?
            WHERE ID = ?;
            """;
    public static final String DELETE = """
            DELETE *
            FROM aeroporto
            WHERE id = ?;
            """;
    public static final String FIND_ALL = """
            SELECT *
            FROM aeroporto;
            """;
    public AirportDaoJdbc(Connection connection) {
        this.connection = connection;
        this.template = new JdbcTemplate(connection);
    }

    @Override
    public Airport create(Airport toSave) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.insert(CREATE, toSave, toSave.getName());
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
            return template.update(UPDATE, newAirport.getName(), newAirport.getId()) == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
    @Override
    public boolean delete(int airportID) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.update(DELETE, airportID) == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
    @Override
    public List<Airport> findAll() throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.queryForObjects(FIND_ALL, AirportDaoJdbc::fromResultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
    static Airport fromResultSet(ResultSet rs) throws SQLException {
            return new Airport(rs.getInt("id"), rs.getString("nome"));
    }
}