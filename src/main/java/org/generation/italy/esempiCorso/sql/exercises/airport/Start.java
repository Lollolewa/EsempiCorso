package org.generation.italy.esempiCorso.sql.exercises.airport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Airport;

public class Start {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
//        Airport airport = new Airport(0, "Malpensa");
//        em.getTransaction().begin();
//        em.persist(airport);
//        em.getTransaction().commit();

        em.getTransaction().begin();
        Airport found1 = em.find(Airport.class, 2);
//        Airport found2 = em.<Airport>find(1);
        if (found1 != null) {
            System.out.println(found1.getName());
        }
        em.getTransaction().commit();

        Airport other = new Airport(1, "Linate");
//        Class<Airport> x = Airport.class;
//        Class<Airport> y = (Class<Airport>) found1.getClass();
        em.getTransaction().begin();
        em.merge(other);
        em.getTransaction().commit();
        System.out.println("Sto per eliminare l'aeroporto");
        em.getTransaction().begin();
        Airport a =  em.find(Airport.class, 1);
        if (a != null) {
            em.remove(a);
        }
        em.getTransaction().commit();
    }
}
