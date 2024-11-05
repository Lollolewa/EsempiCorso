package org.generation.italy.esempiCorso.sql.aereoporto.daos.templates;

import java.sql.*;
import java.util.Optional;
import java.util.function.Function;

public class JdbcTemplate {  //con i tipi Generici, si usa extends sia sulle classi che sulle interfacce
   private Connection connection;

    public JdbcTemplate(Connection connection) {
        this.connection = connection;
    }

    public int update(String sql, Object... params ) throws SQLException { //<-- quando invoco questo metodo, darò una Stringa a Object la gestisce da solo
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            setParameters(ps, params);
            return ps.executeUpdate();
        }
    }
    public <T extends WithId> T insert(String sql, T entity, Object... params) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            setParameters(ps, params);
            ps.executeUpdate();
            try(ResultSet genKeys = ps.getGeneratedKeys()){
                if(genKeys.next()){
                    int key = genKeys.getInt(1);
                    entity.setId(key);
                    return entity;
//                    entity.getClass().getMethod("setId", int.class).invoke(entity, key);
//                    var cl = entity.getClass();
//                    var m = cl.getMethod("setId", int.class);
//                    m.invoke(entity, key);
                }
                throw new SQLException("fallimento nel caricare id autogenerato");
            }
        }
    }
    public <T> Optional<T> findById(String sql, SqlRowMapper<T> rowMapper, int id) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    T result = rowMapper.fromResultSet(rs);
                    return Optional.of(result);
                } else {
                    return Optional.empty();
                }
            }
        }
    }
    private void setParameters(PreparedStatement ps, Object... params) throws SQLException{
        for(int i = 0; i < params.length; i++){
            ps.setObject(i+1, params[i]);
        }
    }
}

