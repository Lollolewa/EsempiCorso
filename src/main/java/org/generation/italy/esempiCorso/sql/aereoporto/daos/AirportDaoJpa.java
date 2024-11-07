package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

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
//            return found != null ? Optional.of(found) : Optional.empty(); //stesso metodo di giu
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
}
