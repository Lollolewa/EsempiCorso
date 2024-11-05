package org.generation.italy.esempiCorso.sql.exercises.airport.model;

public class Ticket {

    private int id;
    private String code;
    private Passenger passenger;

    public Ticket(int id, String code) {
        this.id = id;
        this.code = code;
    }
}