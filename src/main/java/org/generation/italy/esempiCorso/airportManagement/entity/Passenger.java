package org.generation.italy.esempiCorso.airportManagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private int psgid;
    private String firstname, lastname;
    private int airpid;
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(int psgid, String firstname, String lastname, int airpid, List<Ticket> tickets) {
        this.psgid = psgid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.airpid = airpid;
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getAirpid() {
        return airpid;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getPsgid() {
        return psgid;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "psgid=" + psgid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", airpid=" + airpid +
                ", tickets=" + tickets +
                '}';
    }
}
