package org.generation.italy.esempiCorso.sql.aereoporto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

public class Start {
    public static void main(String[] args) {
        // AbstractReservationService ars = new JdbcReservationService();
        // UserInterface ui = new UserInterface(ars);
//        Optional<Connection> optCon = DatabaseConnection.getConnection();
//        if (optCon.isEmpty()) {
//            System.out.println("Impossibile connettersi al database");
//            return; // Se non si può connettersi, esce dal main
//
//        }
//        try (Connection connection = optCon.get()) {
//            AirportDaoJbdc airportDao = new AirportDaoJbdc(connection);
//            Optional<Ticket> ot = airportDao.findTicket("ricominsemo");
//            if(ot.isPresent()){
//                System.out.println(ot.get());
//            }
//            else {
//                System.out.println("Ticket non trovato."); // Stampa il ticket trovato
//            }
//
//        } catch (DaoException | SQLException e) {
//            e.printStackTrace(); // Stampa l'eccezione se si verifica un errore
//        }
//
//
        // ui.setService(new InMemoryReservationService());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
//        Airport airport = new Airport(0,"Malpensa");
//        em.getTransaction().begin();
//        em.persist(airport);
//        em.getTransaction().commit();

        em.getTransaction().begin();
        Airport found = em.find(Airport.class,2);
//        Airport found2 = em.<Airport>find(1);
        if ( found != null) {
            System.out.println(found.getName());
        }
        em.getTransaction().commit();

        Airport other = new Airport(1,"Linate");
//        Class<Airport> x = Airport.class;
//        Class<Airport> y = (Class<Airport>) found.getClass();
//        System.out.println(x==y);
//        em.getTransaction().begin();
//        em.merge(other);
//        em.getTransaction().commit();
//        System.out.println("sto per cancella l'aeroporto");
//        em.getTransaction().begin();
//        Airport a = em.find(Airport.class, 2);
//        if ( a != null) {
//            em.remove(a);
//        }
//        em.getTransaction().commit();
    }
}
