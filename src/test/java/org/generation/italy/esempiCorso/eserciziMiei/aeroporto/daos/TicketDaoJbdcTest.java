package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.daos;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TicketDaoJbdcTest {
// AAA = Arrange, Act, Assert
    @BeforeEach
    void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    void findByCode(){
        System.out.println("findByCode()");
    }

    @Test
    void findByPassengerId(){
        System.out.println("findByPassengerId()");
    }

    @Test
    void create(){
        System.out.println("create()");
    }

    @Test
    void sum_should_sum_positive_numbers(){ // il metodo di test non si deve chiamare per forza come il metodo testato
        int x = 3;
        int y = 5;
        TicketDaoJbdc dao = new TicketDaoJbdc(null);
        int result = dao.sum(x,y);
        assertEquals(8, result); //paragono il risultato del metodo con il risultato del test
    }

    @Test
    void sum_should_invert_one_negative_number(){ // il metodo di test non si deve chiamare per forza come il metodo testato
        int x = 3;
        int y = -5;
        TicketDaoJbdc dao = new TicketDaoJbdc(null);
        int result = dao.sum(x,y);
        assertEquals(8, result); //paragono il risultato del metodo con il risultato del test
    }

    @BeforeAll
    static void setUpBeforeAll(){
        System.out.println("setUpBeforeAll()");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("tearDownAfterAll()");
    }
}