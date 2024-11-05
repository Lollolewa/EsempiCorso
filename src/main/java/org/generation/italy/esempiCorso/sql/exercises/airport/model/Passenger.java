package org.generation.italy.esempiCorso.sql.exercises.airport.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passenger {
    private long id;
    private String name;
    private Airport airport;

    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

}
