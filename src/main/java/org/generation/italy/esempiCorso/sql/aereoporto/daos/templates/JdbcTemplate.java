package org.generation.italy.esempiCorso.sql.aereoporto.daos.templates;

import java.sql.*;
import java.util.Optional;
import java.util.function.Function;

public class JdbcTemplate {  // Questa classe rappresenta un template per lavorare con JDBC usando tipi generici

    private Connection connection;  // Connessione al database

    public JdbcTemplate(Connection connection) {  // Costruttore che riceve una connessione come parametro
        this.connection = connection;  // Assegna la connessione passata alla variabile connection della classe
    }

    public int update(String sql, Object... params) throws SQLException {  // Metodo per eseguire query di update (come insert, delete, update)
        try(PreparedStatement ps = connection.prepareStatement(sql)){  // Crea un PreparedStatement con la query SQL
            setParameters(ps, params);  // Imposta i parametri nella query usando il metodo setParameters
            return ps.executeUpdate();  // Esegue l'aggiornamento e restituisce il numero di righe modificate
        }
    }

    public <T extends WithId> T insert(String sql, T entity, Object... params) throws SQLException {  // Metodo per inserire un'entità nel database
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){  // Prepara la query per generare le chiavi autogenerate
            setParameters(ps, params);  // Imposta i parametri nella query usando setParameters
            ps.executeUpdate();  // Esegue l'aggiornamento

            try(ResultSet genKeys = ps.getGeneratedKeys()){  // Ottiene le chiavi autogenerate dalla query eseguita
                if(genKeys.next()){  // Verifica se c'è una chiave generata
                    int key = genKeys.getInt(1);  // Ottiene il valore della chiave generata
                    entity.setId(key);  // Imposta la chiave come ID dell'entità
                    return entity;  // Restituisce l'entità aggiornata
                }
                throw new SQLException("fallimento nel caricare id autogenerato");  // Lancia eccezione se non trova l'ID autogenerato
            }
        }
    }

    public <T> Optional<T> findById(String sql, SqlRowMapper<T> rowMapper, int id) throws SQLException {  // Metodo per trovare un'entità per ID
        try(PreparedStatement ps = connection.prepareStatement(sql)){  // Crea un PreparedStatement con la query SQL
            ps.setInt(1, id);  // Imposta l'ID come parametro della query
            try(ResultSet rs = ps.executeQuery()) {  // Esegue la query e ottiene il ResultSet
                if(rs.next()){  // Verifica se ci sono risultati
                    T result = rowMapper.fromResultSet(rs);  // Usa il mapper per convertire il ResultSet in un oggetto di tipo T
                    return Optional.of(result);  // Restituisce il risultato in un Optional
                } else {
                    return Optional.empty();  // Se non ci sono risultati, restituisce un Optional vuoto
                }
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {  // Metodo per impostare i parametri nella query
        for(int i = 0; i < params.length; i++){  // Itera su ogni parametro
            ps.setObject(i + 1, params[i]);  // Imposta il parametro nella posizione corretta del PreparedStatement
        }
    }
}
