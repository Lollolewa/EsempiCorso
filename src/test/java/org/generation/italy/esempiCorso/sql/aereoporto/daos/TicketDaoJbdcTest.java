package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class TicketDaoJbdcTest {
    //tripla AAA, arrange, act e assert
    private final static String INSERT_AIRPORT = """
                                                 insert into aeroporto (nome) values (?);
                                                 """;
    private final static String INSERT_PASSENGER= """
                                                   insert into passeggero(nome, aeroporto_id) values (?,?);
                                                   """;
    private final static String INSERT_TICKET= """
                                               insert into ticket(codice, passeggero_id) values (?,?);
                                               """;
    private Airport a1 = new Airport(0, "Malpensa");
    private Passenger p1 = new Passenger(0, "Mario", a1);
    private Passenger p2 = new Passenger(0, "Luigi", a1);
    private Ticket t1 = new Ticket(0, "c1", p1);
    private Ticket t2 = new Ticket(1, "d1", p1);
    private Ticket t3 = new Ticket(2, "31", p2);
    private Connection con;
    private JdbcTemplate template;
    @BeforeEach
    void setUp()  {
        try {
            con = DatabaseConnectionFactoryForTest.getConnection();
            con.setAutoCommit(false);
            template = new JdbcTemplate(con);
            a1 = template.insert(INSERT_AIRPORT, a1, a1.getName(), a1.getId());
            p1 = template.insert(INSERT_PASSENGER, p1, p1.getName(), a1.getId());
            p2 = template.insert(INSERT_PASSENGER, p2, p2.getName(), a1.getId());
            t1 = template.insert(INSERT_TICKET, t1, t1.getCode(), p1.getId());
            t2 = template.insert(INSERT_TICKET, t2, t2.getCode(), p1.getId());
            t3 = template.insert(INSERT_TICKET, t3, t3.getCode(), p2.getId());
        } catch (SQLException e) {
            fail(e.getMessage());
        }



    }

    @AfterEach
    void tearDown() {
        try {
            con.rollback();
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
    //    @Test
//    void sum_should_sum_positive_numbers(){  // <-- dice in dettaglio cosa vado a sommare
//        int x = 3;
//        int y = 5;
//        TicketDaoJbdc dao = new TicketDaoJbdc(null);
//        int result = dao.sum(x, y);
//        assertEquals(8, result);
//    }
//    @Test
//    void sum_should_invert_one_negative_number(){
//        int x = -3;
//        int y = 5;
//        TicketDaoJbdc dao = new TicketDaoJbdc(null);
//        int result = dao.sum(x, y);
//        assertEquals(8, result);
//    }
    @Test
    void findByCode_should_find_with_existing_code() {
        var dao = new TicketDaoJbdc(con);
        try {
            Optional<Ticket> ot = dao.findByCode(t1.getCode());
            assertTrue(ot.isPresent());
            Ticket found = ot.get();
            assertEquals(t1.getId(), found.getId());
            assertNotNull(found.getPassenger());
            assertEquals(p1.getId(), found.getPassenger().getId());
            assertEquals(p1.getName(), found.getPassenger().getName());
            assertNotNull(found.getPassenger().getNearestAirport());
            assertEquals(a1.getId(), found.getPassenger().getNearestAirport().getId());
        } catch (DaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findByCode_shouldnt_find_without_existing_code() {
        var dao = new TicketDaoJbdc(con);
        try {
            Optional<Ticket> ot = dao.findByCode("non esisto");
            assertTrue(ot.isEmpty());
        } catch (DaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findByPassengerId_should_find_for_existing_id() {
        var dao = new TicketDaoJbdc(con);
        try {
            List<Ticket> ticketsP1 = dao.findByPassengerId(p1.getId());
            assertEquals(2, ticketsP1.size());
            List<Ticket> ticketsP2 = dao.findByPassengerId(p2.getId());
            assertEquals(1, ticketsP2.size());
        } catch (DaoException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void findByPassengerId_should_not_find_for_not_existing_id() {
        var dao = new TicketDaoJbdc(con);
        try {
            List<Ticket> ticketsP1 = dao.findByPassengerId(-100);
            assertTrue(ticketsP1.isEmpty());
        } catch (DaoException e) {
            fail(e.getMessage());
        }
    }


    @Test
    void createTicket() {
        var dao = new TicketDaoJbdc(con);
        Ticket tX = new Ticket(0, "aaa", p1);
        try {
            tX = dao.createTicket(tX);
            Optional<Ticket> ot = template.findById(TicketDaoJbdc.FIND_TICKET_BY_ID,
                    TicketDaoJbdc::fromResultSet, tX.getId());
            assertTrue(ot.isPresent());
            Ticket found = ot.get();
            assertEquals(tX.getId(), found.getId());
        } catch (DaoException | SQLException e) {
            fail(e.getMessage());
        }
    }

    @BeforeAll
    static void setUpBeforeAll(){
        System.out.println("setUpBeforeAll()");
    }
    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("tearDownAfterAll");
    }
}