package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.Connection.Dao.DaoException;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AiportDaoJdbc implements AirportDao {
    private Connection connection;
   public static final String FIND_BY_ID = "SELECT nome FROM aeroporto WHERE id = ?"; // Replace with your SQL query
    public static final String CREATE_BY_AIRPORT = """
                                                       INSERT INTO aeroporto (nome) 
                                                       VALUES(?);
                                                       """;
    public static final String UPDATE_AIRPORT = "UPDATE aeroporto SET nome = ? WHERE id = ?";
    public static final String DELETE_AIRPORT = "DELETE FROM aeroporto WHERE id =?";
    public static final String FIND_ALL = "SELECT id, nome FROM aeroporto";

    public AiportDaoJdbc(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Airport create(Airport toSave) throws DaoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(connection);
        try{
        return jdbcTemplate.insert(CREATE_BY_AIRPORT,toSave,toSave.getName());

        } catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.findById(FIND_BY_ID, AiportDaoJdbc::fromResult, id);
        } catch (SQLException e){
            throw  new DaoException(e.getMessage(), e);
        }

    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try{
            return template.update(UPDATE_AIRPORT,newAirport.getName(),newAirport.getId()) == 1;
        } catch (SQLException e){
              throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int aiportID) throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            int n = template.update(DELETE_AIRPORT, aiportID);
            return n == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        JdbcTemplate template = new JdbcTemplate(connection);
        try{
            return template.queryForObjects(FIND_ALL, AiportDaoJdbc::fromResult);
            // Replace with your SQL query to fetch all airports.  The method should return a list of Airport objects.  You can use the static method fromResult(ResultSet rs) to create the Airport objects.

        } catch (SQLException e){
            throw new DaoException(e.getMessage(), e);
        }

    }
    static Airport fromResult(ResultSet rs) throws SQLException{
        return new Airport(rs.getInt("id"),rs.getString("nome"));

    }
}
