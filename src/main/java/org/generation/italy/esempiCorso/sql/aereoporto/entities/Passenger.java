package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import java.util.List;

public class Passenger {
    private int id;
    private String name;
    private List<Ticket> tickets;
    private Airport nearestAirport;

    public Passenger(int id, String name, Airport nearestAirport, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.nearestAirport = nearestAirport;
        this.tickets=tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getNearestAirport() {
        return nearestAirport;
    }

    public void setNearestAirport(Airport nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", nearestAirport=" + nearestAirport.getName() +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
