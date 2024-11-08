package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;

import java.util.List;
import java.util.Optional;

public class AirportDaoJpa implements AirportDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
    EntityManager em = emf.createEntityManager();

    @Override
    public Airport create(Airport toSave) throws DaoException {
        em.getTransaction().begin();
        try {
            em.persist(toSave);
            em.getTransaction().commit();
            return toSave;
        } catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, id);
            em.getTransaction().commit();
//            return found != null ? Optional.of(found) : Optional.empty(); //this method does the same thing as line 37
            return Optional.ofNullable(found);
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, newAirport.getId());
            if(found == null){
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport);
            em.getTransaction().commit();
            return true;
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport airport = em.find(Airport.class, airportID);
            if(airport == null){
                return false;
            }
            em.remove(airport);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        em.getTransaction().begin();
        try {
            var result = em.createQuery("SELECT A FROM AIRPORT A",Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        } catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public Optional<Airport> findByName(String name) throws DaoException {
        try {
            return Optional.ofNullable(em.createQuery("SELECT A FROM AIRPORT A WHERE A.NAME = :NAME", Airport.class)
                           .setParameter("name", "name").getSingleResult());
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public int getAirportCount() throws DaoException {
        try {
            return em.createQuery("SELECT COUNT(A) FROM AIRPORT A", Integer.class)
                     .getSingleResult();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Airport> getByPassengerCounterGreater(int size) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport A WHERE size(a.passenger) > :count", Airport.class)
                     .getResultList();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Airport> findByPassengerName(String passengerName) throws DaoException {
        try {
            return em.createQuery("SELECT a FROM Airport A JOIN a.passengers p WHERE p.name = :name", Airport.class)
                     .setParameter("name",passengerName).getResultList();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Object[]> findWithPassengerCount() throws DaoException {
        try {
            return em.createQuery("SELECT a.id, a.name COUNT(p) FROM Airport A JOIN a.passengers p GROUP BY a.id, a.name",Object[].class)
                     .getResultList();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<AirportPassengerCount> betterFindWithPassengerCount() throws DaoException {
        try {
            return em.createQuery("""
                            SELECT NEW org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount
                            (a.id, a.name COUNT(p))
                            FROM Airport a join a.passenger p
                            GROUP BY a.id, a.name
                            """, AirportPassengerCount.class).getResultList();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

    @Override
    public List<Airport> findWithAvgTicketsPerPassengerAbove(int numTickets) throws DaoException {
        try {
            return em.createQuery("""
                            SELECT a FROM Airport a WHERE(
                            SELECT AVG(SIZE(t.tickets))
                            FROM passenger p
                            WHERE p.airport = a) >= :numTickets
                            """, Airport.class).setParameter("numTickets", numTickets).getResultList();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }

}