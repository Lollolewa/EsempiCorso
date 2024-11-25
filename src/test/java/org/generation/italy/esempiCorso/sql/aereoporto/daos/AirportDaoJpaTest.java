package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.model.AirportPassengerCount;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AirportDaoJpaTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private AirportDaoJpa dao;

    @BeforeAll
    static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatefundamentals");
    }

    @BeforeEach
    void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
        dao = new AirportDaoJpa();
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
    }

    @AfterAll
    static void close() {
        entityManagerFactory.close();
    }

    @Test
    void create() throws DaoException {
        Airport airportToCreate = new Airport(0, "New Airport");
        Airport createdAirport = dao.create(airportToCreate);

        assertNotNull(createdAirport, "The created airport should not be null");
        assertEquals(airportToCreate.getName(), createdAirport.getName(), "The created airport name should match");

        Optional<Airport> optionalAirport = dao.findById(createdAirport.getId());
        assertTrue(optionalAirport.isPresent(), "The created airport should exist in the database");
    }

    @Test
    void findById() throws DaoException {
        Airport airport = dao.create(new Airport(0, "Find Test Airport"));
        Optional<Airport> optionalAirport = dao.findById(airport.getId());

        assertTrue(optionalAirport.isPresent(), "Airport should exist");
        assertEquals(airport.getId(), optionalAirport.get().getId(), "Retrieved ID should match the created ID");
    }

    @Test
    void update() throws DaoException {
        Airport airport = dao.create(new Airport(0, "Airport to Update"));
        assertNotNull(airport, "Created airport should not be null");
        assertTrue(airport.getId() > 0, "Created airport ID should be greater than 0");

        airport.setName("Updated Airport");
        boolean isUpdateSuccessful = dao.update(airport);
        assertTrue(isUpdateSuccessful, "Update should be successful");

        Optional<Airport> optionalAirport = dao.findById(airport.getId());
        assertTrue(optionalAirport.isPresent(), "Updated airport should exist");
        assertEquals("Updated Airport", optionalAirport.get().getName(), "Name should be updated");
    }

    @Test
    void delete() throws DaoException {
        Airport airport = dao.create(new Airport(0, "Airport to Delete"));
        boolean isDeleteSuccessful = dao.delete(airport.getId());

        assertTrue(isDeleteSuccessful, "Delete should be successful");
        assertFalse(dao.findById(airport.getId()).isPresent(), "Airport should not exist after deletion");
    }

    @Test
    void findAll() throws DaoException {
        dao.create(new Airport(0, "Airport 1"));
        dao.create(new Airport(0, "Airport 2"));
        dao.create(new Airport(0, "Airport 3"));

        List<Airport> airports = dao.findAll();
        assertEquals(3, airports.size(), "There should be 3 airports");
    }

    @Test
    void findByName() throws DaoException {
        Airport airport = dao.create(new Airport(0, "Test Airport"));
        Optional<Airport> airports = dao.findByName("Test Airport");

        assertEquals(1, airports.stream(), "One airport with name 'Test Airport' should exist");
        assertEquals(airport.getName(), airports.get().getName(), "Names should match");
    }

    @Test
    void getAirportCount() throws DaoException {
        dao.create(new Airport(0, "Count Test Airport"));
        assertEquals(1, dao.getAirportCount(), "Airport count should be 1");
    }

    @Test
    void getByPassengerCountGreater() throws DaoException {
        // Implementation depending on specific conditions for the test
    }

    @Test
    void findByPassengerName() throws DaoException {
        // Implementation depending on specific conditions for the test
    }

    @Test
    void findWithPassengerCount() throws DaoException {
        // Implementation depending on specific conditions for the test
    }

    @Test
    void betterFindWithPassengerCount() throws DaoException {
        // Implementation depending on specific conditions for the test
    }

    @Test
    void findWithAvgTicketsPerPassengerAbove() throws DaoException {
        // Implementation depending on specific conditions for the test
    }
}
