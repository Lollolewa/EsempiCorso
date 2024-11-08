package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transaction;
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
        emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
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
            Airport b = airportDaoJpa.findById(newA.getId()).get();
            assertNotNull(b);
            assertEquals(newA.getId(), b.getId());
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void findByIdNotFound() {
        int id = 5;
        try {
            Airport b = airportDaoJpa.findById(newA.getId()).get();
            assertNotNull(b);


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
            assertTrue(!didUpdate);
        } catch (DaoException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void delete() {
//        try {
//
//        } catch (DaoException e) {
//            fail(e.getMessage(), e);
//        }
    }

    @Test
    void findAll() {

    }

    @Test
    void findByName() {
    }

    @Test
    void getAirportCount() {
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