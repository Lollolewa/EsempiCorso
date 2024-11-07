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
        em.getTransaction().commit();

        Airport other = new Airport(0,"linate");
        //Class<Airport> x = Airport.class;
        //x = (Class<Airport>) found.getClass(); // cast esplicito
        //oggetto di tipo Class -> tipo speciale che rappresenta le informazioni di tipo di una classe,
        // cioè una rappresentazione in fase di esecuzione (runtime) di una classe, di una interfaccia o di un array.
        // In altre parole, una classe in Java è trattata come un oggetto di tipo Class al momento dell'esecuzione,
        // e puoi utilizzarla per ottenere informazioni sul tipo di una classe o per creare oggetti dinamicamente.

        em.getTransaction().begin();
        em.merge(other);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Airport a = em.find(Airport.class,1);
        if(a!=null){
            em.remove(a);
        }
        em.getTransaction().commit();
    }
}
