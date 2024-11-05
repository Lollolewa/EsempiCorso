package org.generation.italy.esempiCorso.sql.aereoporto.daos.templates;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface SqlRowMapper<T> {
    T fromResultSet(ResultSet rs) throws SQLException;
}
