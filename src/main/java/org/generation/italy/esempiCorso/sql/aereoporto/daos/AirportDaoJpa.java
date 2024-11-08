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
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        em.getTransaction().begin();
        try{
            Airport a = em.find(Airport.class, id);
            em.getTransaction().commit();
            return Optional.ofNullable(a);
//            return a != null?Optional.of(a):Optional.empty();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        em.getTransaction().begin();
        try{
            Airport found = em.find(Airport.class, newAirport.getId());
            if(found == null){
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        em.getTransaction().begin();
        try{
            Airport found = em.find(Airport.class, airportID);
            if(found == null){
                em.getTransaction().rollback();
                return false;
            }
            em.remove(found);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        em.getTransaction().begin();
        try{
            var result = em.createQuery("SELECT a FROM Airport a", Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Airport> findByName(String name) throws DaoException {
        try{
            return Optional.ofNullable(em.createQuery("SELECT a FROM Airport a WHERE a.name = :name", Airport.class)
                    .setParameter("name", name).getSingleResult());
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public int getAirportCount() throws DaoException {
        try{
            return em.createQuery("SELECT count(a) FROM Airport a", Integer.class)
                    .getSingleResult();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> getByPassengerCountGreater(int size) throws DaoException {
        try{
            return em.createQuery("SELECT a FROM Airport a WHERE size(a.passengers) > :count", Airport.class)
                    .getResultList();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findByPassengerName(String passengerName) throws DaoException {
        try{
            return em.createQuery("SELECT a FROM Airport a join a.passengers p WHERE p.name = :name", Airport.class)
                    .setParameter("name", passengerName).getResultList();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Object[]> findWithPassengerCount() throws DaoException {
        try{
            return em.createQuery("SELECT a.id, a.name, count(p) FROM Airport a join a.passengers p GROUP BY a.id, a.name",
                                 Object[].class).getResultList();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<AirportPassengerCount> betterFindWithPassengerCount() throws DaoException { //meglio questo perché Cristo
        try{
            return em.createQuery("""
                                     SELECT new org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount(a.id,
                                     a.name, count(p))
                                     FROM Airport a join a.passengers p
                                     GROUP BY a.id, a.name
                                     """,
                    AirportPassengerCount.class).getResultList();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findWithAvgTicketsPerPassengerAbove(int numTickets) throws DaoException {
        try{
            return em.createQuery("""
                                     SELECT a FROM Airport a WHERE (
                                     SELECT AVG(SIZE(p.tickets)) 
                                     FROM passenger p
                                     WHERE p.airport = a) >= :numTickets
                                     """,
                    Airport.class).setParameter("numTickets", numTickets).getResultList();
        }catch(PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }
}
