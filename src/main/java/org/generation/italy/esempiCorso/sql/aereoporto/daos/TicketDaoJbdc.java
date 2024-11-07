package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoJbdc implements TicketDao {  // Classe che implementa l'interfaccia TicketDao per gestire i biglietti tramite JDBC

    public static final String CREATE_NEW_TICKET = "INSERT INTO ticket (codice, passeggero_id) values(?, ?)";  // Query SQL per creare un nuovo biglietto
    public static final String FIND_TICKET_BY_CODE = """
                                                    // Query SQL per trovare un biglietto tramite il codice
                                                    SELECT t.id AS ticket_id, t.codice AS ticket_code, p.id AS passenger_id,
                                                           p.nome AS passenger_name, a.id AS airport_id, a.nome AS airport_name
                                                    FROM ticket AS t
                                                    JOIN passeggero AS p
                                                    ON t.passeggero_id = p.id
                                                    JOIN aeroporto AS a
                                                    ON a.id = p.aeroporto_id
                                                    WHERE codice = ?;
                                                    """;
    public static final String FIND_TICKETS_FOR_PASSENGER = """  
                                                            // Query SQL per trovare tutti i biglietti di un passeggero
                                                            SELECT t.id AS ticket_id, t.codice AS ticket_code, p.id AS passenger_id,
                                                                p.nome AS passenger_name, a.id AS airport_id, a.nome AS airport_name
                                                            FROM ticket AS t
                                                            JOIN passeggero AS p
                                                            ON t.passeggero_id = p.id
                                                            JOIN aeroporto AS a
                                                            ON a.id = p.aeroporto_id
                                                            WHERE t.passeggero_id = ?
                                                            """;
    public static final String FIND_TICKET_BY_ID = """  
                                                    // Query SQL per trovare un biglietto tramite l'ID
                                                    SELECT t.id AS ticket_id, t.codice AS ticket_code, p.id AS passenger_id, p.nome AS passenger_name,
                                                    a.id AS airport_id, a.nome AS airport_name
                                                    FROM ticket AS t
                                                    JOIN passeggero AS p
                                                    ON t.passeggero_id = p.id
                                                    JOIN aeroporto AS a
                                                    ON a.id = p.aeroporto_id
                                                    WHERE t.id = ?;
                                                    """;

    private Connection connection;  // Connessione al database

    public TicketDaoJbdc(Connection connection) {  // Costruttore che riceve una connessione come parametro
        this.connection = connection;  // Inizializza la connessione
    }

    @Override
    public Optional<Ticket> findByCode(String code) throws DaoException {  // Metodo per trovare un biglietto tramite il codice
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKET_BY_CODE)) {  // Prepara l'istruzione SQL
            ps.setString(1, code);  // Imposta il codice del biglietto come parametro della query
            try (ResultSet rs = ps.executeQuery()) {  // Esegue la query e ottiene i risultati
                if (rs.next()) {  // Verifica se ci sono risultati
                    return Optional.of(fromResultSet(rs));  // Restituisce il biglietto trovato
                } else {
                    return Optional.empty();  // Restituisce Optional vuoto se non trovato
                }
            }
        } catch (SQLException e) {  // Gestisce le eccezioni SQL
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);  // Lancia una DaoException con il messaggio dell'eccezione
        }
    }

    static Ticket fromResultSet(ResultSet rs) throws SQLException {  // Metodo per creare un oggetto Ticket dai dati del ResultSet
        Ticket t = new Ticket(  // Crea un oggetto Ticket
                rs.getInt("ticket_id"),  // Ottiene l'ID del biglietto
                rs.getString("ticket_code"),  // Ottiene il codice del biglietto
                new Passenger(  // Crea un oggetto Passenger associato al biglietto
                        rs.getInt("passenger_id"),  // Ottiene l'ID del passeggero
                        rs.getString("passenger_name"),  // Ottiene il nome del passeggero
                        new Airport(  // Crea un oggetto Airport associato al passeggero
                                rs.getInt("airport_id"),  // Ottiene l'ID dell'aeroporto
                                rs.getString("airport_name"),  // Ottiene il nome dell'aeroporto
                                new ArrayList<Passenger>()  // Lista vuota di passeggeri per l'aeroporto
                        ),
                        new ArrayList<Ticket>()  // Lista vuota di biglietti per il passeggero
                )
        );
        return t;  // Restituisce l'oggetto Ticket creato
    }

    @Override
    public List<Ticket> findByPassengerId(int id) throws DaoException {  // Metodo per trovare i biglietti di un passeggero tramite il suo ID
        List<Ticket> tickets = new ArrayList<>();  // Lista vuota per i biglietti
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_FOR_PASSENGER)) {  // Prepara la query SQL
            ps.setInt(1, id);  // Imposta l'ID del passeggero come parametro
            try (ResultSet rs = ps.executeQuery()) {  // Esegue la query e ottiene i risultati
                while (rs.next()) {  // Itera sui risultati
                    Ticket t = fromResultSet(rs);  // Crea un Ticket dal ResultSet
                    tickets.add(t);  // Aggiunge il Ticket alla lista
                }
                return tickets;  // Restituisce la lista di biglietti
            }
        } catch (SQLException e) {  // Gestisce le eccezioni SQL
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);  // Lancia una DaoException
        }
    }

    @Override
    public Ticket createTicket(Ticket t) throws DaoException {  // Metodo per creare un nuovo biglietto nel database
        try (PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TICKET,
                PreparedStatement.RETURN_GENERATED_KEYS)) {  // Prepara la query per inserire il biglietto e ottenere l'ID generato

            ps.setString(1, t.getCode());  // Imposta il codice del biglietto come parametro
            ps.setInt(2, t.getPassenger().getId());  // Imposta l'ID del passeggero come parametro

            ps.executeUpdate();  // Esegue l'aggiornamento (inserimento del biglietto)

            try (ResultSet genKeys = ps.getGeneratedKeys()) {  // Ottiene le chiavi generate (ID del biglietto)
                if (genKeys.next()) {  // Verifica se è stato generato un ID
                    int id = genKeys.getInt(1);  // Ottiene l'ID generato
                    t.setId(id);  // Imposta l'ID nel biglietto
                }
            }
            return t;  // Restituisce il biglietto creato

        } catch (SQLException e) {  // Gestisce le eccezioni SQL
            throw new org.generation.italy.esempiCorso.sql.dao.DaoException(e.getMessage(), e);  // Lancia una DaoException
        }
    }
}
