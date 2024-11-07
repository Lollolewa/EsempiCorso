package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirportDaoJdbc implements AirportDao {

    Connection connection;

    public final static String FIND_BY_ID = """
            SELECT ID, NOME
            FROM AEROPORTO
            WHERE ID = ?
            """;

    public final static String INSERT_SQL = """
            INSERT INTO AEROPORTO(ID, NOME)
            VALUES(?,?)
            """;

    public final static String UPDATE_SQL = """
            UPDATE AEROPORTO
            NOME = ?
            WHERE ID = ?
            """;

    public final static String DELETE_SQL = """
            DELETE FROM AIRPORT
            WHERE ID = ?
            """;

    public final static String FIND_ALL = """
            SELECT ID, NOME
            FROM AEROPORTO
            """;

    @Override
    public Airport create(Airport toSave) throws DaoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(connection);
        try{
            return jdbcTemplate.insert(INSERT_SQL,toSave,toSave.getId(),toSave.getName());
        }catch (SQLException e){
            throw new DaoException(e.getMessage(),e);
        }

    }

    public Optional<Airport> findById(int id) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.findById(FIND_BY_ID,AirportDaoJdbc::fromResultSet,id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.update(UPDATE_SQL, newAirport.getName(),newAirport.getId()) == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.update(DELETE_SQL, airportID) == 1;
        }catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }

    }

    @Override
    public List<Airport> findAll() throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try{
            return template.queryForObjects(FIND_ALL,AirportDaoJdbc::fromResultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    static Airport fromResultSet(ResultSet rs) throws SQLException{
        return new Airport(rs.getInt("id"), rs.getString("nome"));
    }
}
