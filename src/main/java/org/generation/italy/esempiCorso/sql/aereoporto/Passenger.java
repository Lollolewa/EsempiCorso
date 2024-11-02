package org.generation.italy.esempiCorso.sql.aereoporto;

import java.util.List;

public class Passenger {
    private int id,nearestAirportID;
    private String name;
    private List<Ticket> tickets;

    public Passenger(int id, String name, int nearestAirportID, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.nearestAirportID = nearestAirportID;
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

    public int getNearestAirportID() {
        return nearestAirportID;
    }

    public void setNearestAirportID(int nearestAirportID) {
        this.nearestAirportID = nearestAirportID;
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
                ", nearestAirportID=" + nearestAirportID +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
