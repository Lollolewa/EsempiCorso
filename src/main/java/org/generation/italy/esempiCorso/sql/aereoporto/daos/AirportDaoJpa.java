package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportDaoJpa implements AirportDao{
    EntityManager em;

    public AirportDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Airport create(Airport toSave) throws DaoException {
        em.getTransaction().begin();
        try {
            em.persist(toSave);
            em.getTransaction().commit();
            return toSave;//hibernate una volta committato, aggiorna automaticamente l'oggetto su java
            // (aggiorna quindi l'id nel caso in cui fosse 0 e lo creasse in automatico, trasformandolo in 1)
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        em.getTransaction().begin();
        try{
            Airport a = em.find(Airport.class, id);
            em.getTransaction().commit();
//            return a != null ? Optional.of(a) : Optional.empty();
            return Optional.ofNullable(a);

        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, newAirport.getId());
            if(found == null) {
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }


    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, airportID);
            if(found==null) {
                em.getTransaction().rollback();
                return false;
            }
            em.remove(found);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        List<Airport> airports = new ArrayList<>();
        em.getTransaction().begin();
        try {
            var result = em.createQuery("SELECT a FROM Airport a", Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }
}
