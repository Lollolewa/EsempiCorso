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
    public final static String FIND_BY_ID = """
                                            SELECT id,nome FROM aeroporto WHERE id=?
                                            """;

    public AirportDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Airport create(Airport toSave) throws DaoException {
        return null;
    }

    @Override
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
        return false;
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        return false;
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        return List.of();
    }

    static Airport fromResultSet(ResultSet rs) throws SQLException{
        return new Airport(rs.getInt("id"), rs.getString("nome"));
    }
}
