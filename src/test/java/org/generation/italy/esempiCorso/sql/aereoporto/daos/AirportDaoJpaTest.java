package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transaction;
import org.checkerframework.checker.units.qual.A;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AirportDaoJpaTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    Airport a = new Airport(0, "kdhjafadjfbhkl");
    Airport a3 = new Airport(4, "kdhjafadjfbhkl");
    Airport a2 = new Airport(0, "Mimmo");
    Airport newA = new Airport(1, "Malpensa");
    AirportDaoJpa airportDaoJpa = new AirportDaoJpa();

    @BeforeAll
    public static void setUpBeforeAll(){
        AirportDaoJpa airportDaoJpa1 = new AirportDaoJpa();
        EntityManagerFactory emf = airportDaoJpa1.emf;
        EntityManager em = emf.createEntityManager();
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        if(em != null){
            em.getTransaction().rollback();
            em.close();
        }
    }

    @Test
    void create() {
        try {
            Airport justCreated = airportDaoJpa.create(a);
            assertEquals(a, justCreated);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void findById() {
        try {
            Optional<Airport> comparingAeroporto = airportDaoJpa.findById(newA.getId());
            assertNotNull(comparingAeroporto);
            Airport a = comparingAeroporto.get();
            assertEquals(newA.getId(), a.getId());
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void findByIdNotFound() {
        try {
            Optional<Airport> b = airportDaoJpa.findById(newA.getId());
            assertNotNull(b);
            Airport b2 = b.get();
            assertTrue(b2.getId() != newA.getId());
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void update() {
        try {
            boolean didUpdate = airportDaoJpa.update(a3);
            assertTrue(didUpdate);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void updateDoesNotFindAirport() {
        try {
            boolean didUpdate = airportDaoJpa.update(a2);
            assertFalse(didUpdate);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void delete() {
        int id = 6;
        try {
            boolean didDelete = airportDaoJpa.delete(id);
            assertTrue(didDelete);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void deleteDidNotFindId() {
        int id = 8;
        try {
            boolean didDelete = airportDaoJpa.delete(id);
            assertFalse(didDelete);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void findAll() {

    }

    @Test
    void findByName() {
        String name = "Malpensa";
        try {
            Optional<Airport> a = airportDaoJpa.findByName(name);
            assertNotNull(a);
            Airport a0 = a.get();
            assertEquals(name, a0.getName());
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void findByNameNotFound() {
        String name = "Malpe";
        try {
            Optional<Airport> a = airportDaoJpa.findByName(name);
            assertTrue(a.isEmpty());  //?????????
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void getAirportCount() {
        try {
            int n = airportDaoJpa.getAirportCount();
            assertEquals(5, n); //??????
        }
        catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void getByPassengerCountGreater() {

    }

    @Test
    void findByPassengerName() {
    }

    @Test
    void findWithPassengerCount() {
    }

    @Test
    void betterFindWithPassengerCount() {
    }

    @Test
    void findWithAvgTicketsPerPassengerAbove() {
    }

    @AfterAll
    static void tearDownAfterAll(){
        if (emf != null) {
            emf.close();
        }
    }
}