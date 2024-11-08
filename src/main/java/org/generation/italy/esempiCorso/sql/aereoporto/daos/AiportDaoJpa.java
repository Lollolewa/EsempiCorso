package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.generation.italy.esempiCorso.Connection.Dao.DaoException;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;

import java.util.List;
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
        try{
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
        try{
            Airport found = em.find(Airport.class, newAirport);
            if(found!= null){
                em.getTransaction().rollback();
                return false;
            }
            em.merge(newAirport); //merge si usa per fare l'update dentro il database
            em.getTransaction().commit();
            return true;
        }catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }

    }

    @Override
    public boolean delete(int aiportID) throws DaoException {
        em.getTransaction().begin();
        try{
            Airport found = em.find(Airport.class,aiportID);
            if(found!=null){
                em.getTransaction().rollback();
                return false;
            }
            em.remove(found);
            em.getTransaction().commit();
            return  true;
        } catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }

    }

    @Override
    public List<Airport> findAll() throws DaoException {
        em.getTransaction().begin();
        try{
            var result =  em.createQuery("SELECT a FROM airport A",Airport.class).getResultList();
            em.getTransaction().commit();
            return result;
        }catch (PersistenceException e){
            em.getTransaction().rollback();
            throw new DaoException(e.getMessage(),e);
        }
    }
}
