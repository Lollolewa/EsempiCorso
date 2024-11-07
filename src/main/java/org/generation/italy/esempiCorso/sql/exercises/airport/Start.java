package org.generation.italy.esempiCorso.sql.exercises.airport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

public class Start {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
        Airport airport = new Airport(0, "Malepensa");
        em.getTransaction().begin();
        em.persist(airport);
        em.getTransaction().commit();

//        em.getTransaction().begin();
//        Airport found = em.find(Airport.class, 1);
//        if (found != null){
//            System.out.println(found.getName());
//        }
//        Airport other = new Airport(0, "Linate"); //classe in java di nome class
//        Class<Airport> x = Airport.class;
//        Class<Airport> y = (Class<Airport>) found.getClass();
//        System.out.println(x == y);
    }
}
