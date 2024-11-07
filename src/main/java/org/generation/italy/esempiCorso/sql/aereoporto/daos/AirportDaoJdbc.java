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

    public AirportDaoJdbc(Connection connection){
        this.connection = connection;
        this.template = new JdbcTemplate(connection);
    }

    public final static String CREATE_AIRPORT = """
                                                insert into aeroporto (nome)
                                                values (?);
                                                """;
    public final static String FIND_BY_ID = """
                                            select nome
                                            from aeroporto
                                            where id = ?;
                                            """;
    public final static String UPDATE_AIRPORT = """
                                                update aeroporto
                                                set nome = ?
                                                where id = ?
                                                """;
    public final static String DELETE_AIRPORT = """
                                                delete from aeroporto
                                                where id = ?
                                                """;
    public final static String FIND_ALL_AIRPORT = """
                                                  select id, nome
                                                  from aeroporto
                                                  """;
    @Override
    public Airport create(Airport toSave) throws DaoException {
        try {
           return template.insert(CREATE_AIRPORT,toSave,toSave.getName());
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        try {
            return template.findById(FIND_BY_ID,AirportDaoJdbc::fromResultSet,id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        try {
            return template.update(UPDATE_AIRPORT,newAirport.getName(),newAirport.getId()) == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }

    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        try {
            return template.update(DELETE_AIRPORT,airportID) == 1;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        try {
            return template.queryForObjects(FIND_ALL_AIRPORT,AirportDaoJdbc::fromResultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
    }

    static Airport fromResultSet(ResultSet rs) throws SQLException{
        return new Airport(rs.getInt("id"),rs.getString("nome"));
    }

}
