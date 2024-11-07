package org.generation.italy.esempiCorso.sql.exercises.airport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Airport;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Passenger;


public class Start {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
//        Airport a1 = new Airport(0, "Malpensa");
//        em.getTransaction().begin();
//        em.persist(a1);
//        em.getTransaction().commit();

        em.getTransaction().begin();
        Airport found = em.find(Airport.class, 1);
        if(found != null) {
            System.out.println(found.getName());
        }
        em.getTransaction().commit();

        Airport other = new Airport(0,"Linate");
//        Class<Airport> x = Airport.class; // Oggetto di tipo (class) che descrive la struttura della classe.
//        Class<Airport> y = (Class<Airport>) found.getClass(); // La stessa cosa di sopra solo piu specifico.
        em.getTransaction().begin();
        em.merge(other);
        em.getTransaction().commit();
        System.out.println("Sto per cancellare l'aeroporto");

        em.getTransaction().begin();
        Airport a = em.find(Airport.class, 1);
        if (a  != null){
            em.remove(a);
        }
        em.getTransaction().commit();
    }
}
