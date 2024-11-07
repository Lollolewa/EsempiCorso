package org.generation.italy.esempiCorso.sql.exercises.airport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Airport;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Passenger;

import java.sql.SQLOutput;

public class Start {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
//        Airport airport = new Airport(0,"Malpensa");
//        em.getTransaction().begin();
//        em.persist(airport);
//        em.getTransaction().commit();
//a
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
        em.getTransaction().begin();
        em.merge(other);
        em.getTransaction().commit();
        System.out.println("sto per cancella l'aeroporto");
        em.getTransaction().begin();
        Airport a = em.find(Airport.class, 2);
        if ( a != null) {
            em.remove(a);
        }
        em.getTransaction().commit();
    }
}
