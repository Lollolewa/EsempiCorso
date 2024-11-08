package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportDaoJpa implements AirportDao {
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
        try {
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
            if (found == null) {
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
            if (found == null) {
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

    @Override
    public Optional<Airport> findByName(String name) throws DaoException {
        try {
            return Optional.ofNullable(em.createQuery("SELECT a FROM Airport a WHERE a.name = :name", Airport.class)
                    .setParameter("name", name).getSingleResult());
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);

        }
    }

    @Override
    public int getAirportCount() throws DaoException {
        try {
            return (em.createQuery("SELECT COUNT(a) FROM Airport a", Integer.class)
                    .getSingleResult());
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);

        }
    }

    @Override
    public List<Airport> getByPassengerCountGreater(int size) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport a WHERE size(a.passengers) > :count", Airport.class)
                    .getResultList();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);

        }
    }

    @Override
    public List<Airport> findByPassengerName(String passengerName) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport a JOIN a.passengers p WHERE p.name = :name", Airport.class)
                    .setParameter("name", passengerName).getResultList();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public List<Object[]> findWithPassengerCount() throws DaoException {
        try {
            return em.createQuery("SELECT a.id, a.name, COUNT(p) FROM Airport a JOIN a.passengers p GROUP BY a.id, a.name",
                            Object[].class).getResultList();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public List<AirportPassengerCount> bestFindWithPassengerCount() throws DaoException {
        try {
            return em.createQuery("""
                            SELECT new org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount(a.id,
                            a.name, count(p))
                            FROM Airport a
                            JOIN a.passengers p
                            GROUP BY a.id, a.name
                            """,
                    AirportPassengerCount.class).getResultList();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }

    @Override
    public List<Airport> findWithAvgTicketsPerPassengerAbove(int numTickets) throws DaoException {
        try {
            return em.createQuery("""
                                     SELECT a FROM Airport a WHERE (
                                     SELECT AVG(SIZE(p.tickets))
                                     FROM passenger p
                                     WHERE p.airport = a) >= :numTickets
                                     """,
                    Airport.class).setParameter("numTickets", numTickets).getResultList();
        } catch (PersistenceException pe) {
            em.getTransaction().rollback();
            throw new DaoException(pe.getMessage(), pe);
        }
    }
}