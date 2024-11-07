package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.aereoporto.model.PassengerData;
import org.generation.italy.esempiCorso.sql.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerDaoJbdc implements PassengerDao {  // Classe che implementa l'interfaccia PassengerDao per gestire i passeggeri tramite JDBC

    private Connection connection;  // Connessione al database

    public PassengerDaoJbdc(Connection connection) {  // Costruttore che riceve una connessione come parametro
        this.connection = connection;  // Inizializza la connessione passata
    }

    private static final String FIND_TICKETS_EVER_BOUGHT = """  
            // Query SQL per trovare i passeggeri e il numero di biglietti acquistati
            SELECT p.id AS passenger_id, p.nome AS passenger_name,
                   a.id AS airport_id, a.nome AS airport_name,
                   COUNT(t.id) AS num_tickets  // Conta il numero di biglietti acquistati dal passeggero
            FROM passeggero AS p
            LEFT JOIN ticket AS t ON p.id = t.passeggero_id  // Join tra passeggero e ticket per includere i biglietti acquistati
            JOIN aeroporto AS a ON a.id = p.aeroporto_id  // Join tra passeggero e aeroporto per includere i dati dell'aeroporto di origine
            GROUP BY p.id, p.nome, a.nome, a.id  // Raggruppa per passeggero e aeroporto per ottenere il conteggio corretto
            ORDER BY num_tickets DESC  // Ordina i risultati in ordine decrescente di numero di biglietti
            """;

    private static final String DELETE_PASSENGER = "DELETE FROM passeggero WHERE ID = ?";  // Query SQL per eliminare un passeggero in base al suo ID

    @Override
    public List<PassengerData> findAllOrderedByNumTickets() throws DaoException {  // Metodo per trovare tutti i passeggeri ordinati per numero di biglietti acquistati
        List<PassengerData> passengers = new ArrayList<>();  // Crea una lista vuota di PassengerData
        try (PreparedStatement ps = connection.prepareStatement(FIND_TICKETS_EVER_BOUGHT);  // Prepara l'istruzione SQL
             ResultSet rs = ps.executeQuery()) {  // Esegue la query e ottiene i risultati
            while (rs.next()) {  // Itera sui risultati
                Passenger p = new Passenger(  // Crea un oggetto Passenger con i dati del ResultSet
                        rs.getInt("passenger_id"),  // Ottiene l'ID del passeggero
                        rs.getString("passenger_name"),  // Ottiene il nome del passeggero
                        new Airport(  // Crea un oggetto Airport per l'aeroporto di origine del passeggero
                                rs.getInt("airport_id"),  // Ottiene l'ID dell'aeroporto
                                rs.getString("airport_name"),  // Ottiene il nome dell'aeroporto
                                new ArrayList<Passenger>()  // Inizializza una lista vuota di passeggeri per l'aeroporto
                        ),
                        new ArrayList<Ticket>()  // Inizializza una lista vuota di biglietti per il passeggero
                );
                PassengerData pd = new PassengerData(p, rs.getInt("num_tickets"));  // Crea un PassengerData con il passeggero e il numero di biglietti
                passengers.add(pd);  // Aggiunge il PassengerData alla lista
            }
            return passengers;  // Restituisce la lista di passeggeri ordinata

        } catch (SQLException e) {  // Gestisce le eccezioni SQL
            throw new DaoException(e.getMessage(), e);  // Lancia una DaoException con il messaggio dell'eccezione
        }
    }

    @Override
    public boolean deletePassengerById(int id) throws DaoException {  // Metodo per eliminare un passeggero dal database tramite il suo ID
        try (PreparedStatement ps = connection.prepareStatement(DELETE_PASSENGER)) {  // Prepara la query SQL per eliminare il passeggero
            ps.setInt(1, id);  // Imposta l'ID come parametro della query
            int n = ps.executeUpdate();  // Esegue l'aggiornamento e restituisce il numero di righe modificate
            return n == 1;  // Restituisce true se una riga è stata eliminata, altrimenti false
        } catch (SQLException e) {  // Gestisce le eccezioni SQL
            throw new DaoException(e.getMessage(), e);  // Lancia una DaoException con il messaggio dell'eccezione
        }
    }
    public Optional<Passenger> findById(int id) {
        JdbcTemplate template = new JdbcTemplate(connection);
        try {
            return template.findById(FIND_BY_ID, PassengerDaoJdbc::fromResultSet, id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }

    }
}
