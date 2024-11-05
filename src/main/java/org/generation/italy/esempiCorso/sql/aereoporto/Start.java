package org.generation.italy.esempiCorso.sql.aereoporto;
import org.generation.italy.esempiCorso.sql.DatabaseConnection;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.generation.italy.esempiCorso.sql.dao.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Start {
    public static void main(String[] args) {
        Optional<Connection> optCon = DatabaseConnection.getConnection();
        if (optCon.isEmpty()) {
            System.out.println("Impossibile connettersi al database");
            return; // Se non si può connettersi, esce dal main

        }
        try (Connection connection = optCon.get()) {
            AirportDaoJbdc airportDao = new AirportDaoJbdc(connection);
            Optional<Ticket> ot = airportDao.findTickets("ricominsemo");
            if(ot.isPresent()){
                System.out.println(ot.get());
            }
            else {
                System.out.println("Ticket non trovato."); // Stampa il ticket trovato
            }

        } catch (DaoException | SQLException e) {
            e.printStackTrace(); // Stampa l'eccezione se si verifica un errore
        }


    }
}
