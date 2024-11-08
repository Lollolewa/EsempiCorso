package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.Connection.Dao.DaoException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AiportDaoJpa implements AirportDao {
    private EntityManager em; //costruire entity, abbiamo bisogno di una sola classe factory

    //non vogliamo un pool di connessioni, manager si carica il database nella sua cach,
    public void AirportDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Airport create(Airport toSave) throws DaoException {
        em.getTransaction().begin();
        try {
            em.persist(toSave);
            em.getTransaction().commit();
            return toSave;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);

        }

    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport a = em.find(Airport.class, id);
            em.getTransaction().commit();
            return Optional.ofNullable(a); //senza dover fare if else

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);

        }

    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, newAirport);
            if (found != null) {
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport); //merge si usa per fare l'update dentro il database
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }

    }

    @Override
    public boolean delete(int aiportID) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, aiportID);
            if (found != null) {
                em.getTransaction().rollback();
                return false;
            }
            em.remove(found);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }

    }

    @Override
    public List<Airport> findAll() throws DaoException {
        em.getTransaction().begin();
        try {
            var result = em.createQuery("SELECT a FROM airport A", Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findByName(String name) throws DaoException {
        try {
            return Optional.ofNullable(em.createQuery("SELECT a FROM Airport a where a.name = :name", Airport.class)
                    .setParameter("name", name).getSingleResult());

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public int getAirportCount() throws DaoException {
        try {
            return em.createQuery("SELECT count(a) FROM Airport a ", Integer.class)
                    .getSingleResult();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> getByPassengerCountGreater(int size) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport a where size(a.passengers) > :count", Airport.class)
                    .getResultList();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> byFinderPassengerName(String passengerName) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport a JOIN a.passengers p where p.name = :name", Airport.class)
                    .setParameter("name", passengerName)
                    .getResultList();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Objects[]> findWithPassengerCount() throws DaoException {
        try {
            return em.createQuery("SELECT a.id,a.name,count(p) FROM Airport a JOIN a.passengers p GROUP BY a.id,a.name", Objects[].class)
                    .getResultList();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<AirportPassengerCount> bestFindByPassengerCount() throws DaoException {
        try {
            return em.createQuery("""
                            SELECT new org.generation.italy.esempiCorso.sql.aereoporto.model.AiportPassengerCount
                            (a.id,a.name,count(p))
                            FROM Airport a JOIN a.passengers p
                            GROUP BY a.id, a.name
                            
                            """,

                    AirportPassengerCount.class).getResultList();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findWithAvgTicketPerPassengerAboveIntNumTickets(int numTickets) throws DaoException {
        try {
            return em.createQuery("""SELECT a FROM Airport a WHERE(
                            SELECT AVG(SIZE(p.ticket)) 
                            FROM passenger p
                            WHERE p.airport = a) >= :numTickets
                            """,
                    Airport.class).setParameter("numTickets", numTickets).getResultList();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }
}