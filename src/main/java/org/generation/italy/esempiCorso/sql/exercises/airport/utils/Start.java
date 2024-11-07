package org.generation.italy.esempiCorso.sql.exercises.airport.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.exercises.airport.model.Airport;

public class Start {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager(); //em è l'entity Manager
        Airport airport = new Airport(1, "Malpensa"); //aggiunge un aeroporto nella colonna aeroporto del mio database
        em.getTransaction().begin();
        em.persist(airport);
        em.getTransaction().commit();

//        em.getTransaction().begin();
//        Airport found = em.find(Airport.class, 4); //cerca un aeroporto con id=4 e me lo salva nell'oggetto found
//        if (found!=null){
//            System.out.println(found.getName());
//        }

    }
}
