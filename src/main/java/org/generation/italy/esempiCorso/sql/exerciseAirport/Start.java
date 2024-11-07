package org.generation.italy.esempiCorso.sql.exerciseAirport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.exerciseAirport.model.Airport;

public class Start {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();
        Airport airport = new Airport(0,"malpensa");
        em.getTransaction().begin();
        em.persist(airport);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Airport found = em.find(Airport.class,1);
        if(found!= null){
            System.out.println(found.getName());
        }

        Airport other = new Airport(0,"linate");
        Class<Airport> x = Airport.class;
        x = (Class<Airport>) found.getClass(); // cast esplicito
        //oggetto di tipo Class ch
    }
}
