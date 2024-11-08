package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class AirportDaoJpaTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
    EntityManager em = emf.createEntityManager();
    AirportDaoJpa adj = new AirportDaoJpa(em);
    Airport a1 = new Airport(1, "Malpensa");
    Airport a2 = new Airport(2, "Linate");
    Airport a3 = new Airport(3, "Napoli");
    Airport a4 = new Airport(4, "Tokyo");
    Airport a5 = new Airport(5, "SUF");
    Airport a6 = new Airport(6, "London");



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create(){ //non va
        try {
            var z = adj.create(a6);
            assertEquals(6, a6.getId());
            assertEquals("London", a6.getName());
        } catch (DaoException de) {
            fail(de.getMessage());
        }
    }

    @Test
    void findById() { //funziona
        try {
            Optional<Airport> ot = adj.findById(a5.getId());
            assertTrue(ot.isPresent());
            Airport found = ot.get();
            assertEquals(a5.getId(), found.getId());
        } catch (DaoException de) {
            fail(de.getMessage());
        }
    }

    @Test
    void update() { //se non trova l'id non funziona e non rollbacka
        try {
            var z = adj.update(a2);
            assertTrue(z);
        } catch (DaoException de) {
            fail(de.getMessage());
        }
    }

    @Test
    void delete() { //se non trova l'id non funziona e non rollbacka
        try {
            var z = adj.delete(a5.getId());
            assertTrue(z);
        } catch (DaoException de) {
            fail(de.getMessage());
        }
    }

    @Test
    void findAll() {
        try {
            var z = adj.findAll();
            assertEquals(List.of(a1, a2, a3), List.of());
        } catch (DaoException de) {
            fail(de.getMessage());
        }
    }

    @Test
    void findByName() {
        try {

        } catch (DaoException de) {
            fail(de.getMessage());
        }
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
    void bestFindWithPassengerCount() {
    }

    @Test
    void findWithAvgTicketsPerPassengerAbove() {
    }
}