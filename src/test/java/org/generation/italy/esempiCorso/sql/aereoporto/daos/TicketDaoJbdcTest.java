package org.generation.italy.esempiCorso.sql.aereoporto.daos;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.JdbcTemplate;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Airport;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private Ticket t1 = new Ticket(0, "c1", p1);
    private Connection con;
    private JdbcTemplate template;
    @BeforeEach
    void setUp()  {
        try {
            con = DatabaseConnectionFactoryForTest.getConnection();
            con.setAutoCommit(false);
            template = new JdbcTemplate<Airport>(con);
            Airport a1Id = template.insert(INSERT_AIRPORT, a1, a1.getName());
        } catch (SQLException e) {
            fail(e.getMessage());
        }

    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown()");
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
    void findByCode() {

    }

    @Test
    void findByPassengerId() {
        System.out.println("findByPassengerId()");
    }

    @Test
    void createTicket() {
        System.out.println("createTicket()");
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