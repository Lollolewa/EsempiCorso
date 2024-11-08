package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.util.List;
import java.util.Optional;

public class AirportDaoJpa implements AirportDao{
    private final EntityManager em;
    public AirportDaoJpa(EntityManager em) {
        this.em = em;
    }
    @Override
    public Airport create(Airport toSave) throws DaoException {
        em.getTransaction().begin();
        try{
            em.persist(toSave);
            em.getTransaction().commit();
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
        return toSave;
    }

    @Override
    public Optional<Airport> findById(int id) throws DaoException {
        try {
            Airport a = em.find(Airport.class, id);
            return Optional.ofNullable(a);
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Airport newAirport) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport found = em.find(Airport.class, newAirport.getId());
            if (found!= null) {
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int airportID) throws DaoException {
        em.getTransaction().begin();
        try {
            Airport airport = em.find(Airport.class, airportID);
            if (airport != null) {
                em.remove(airport);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().rollback();
            return false;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<Airport> findAll() throws DaoException {
        try {
            var result = em.createQuery("SELECT a FROM Airport a", Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        } catch (PersistenceException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
