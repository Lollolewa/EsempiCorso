package org.generation.italy.esempiCorso.sql2.model;

import java.util.ArrayList;
import java.util.List;

public class Passengers {
    private int passengerId, ticketsCount;
    private String firstname;
    private String lastName;
    private Airport nearestAirport;
    private List<Tickets> listOfTickets = new ArrayList<>();

    public Passengers(int passengerId, int ticketsCount, String firstname, String lastName, Airport nearestAirport, List<Tickets> listOfTickets){
        this.passengerId = passengerId;
        this.ticketsCount = ticketsCount;
        this.firstname = firstname;
        this.lastName = lastName;
        this.nearestAirport = nearestAirport;
        this.listOfTickets = listOfTickets;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public Airport getNearestAirport() {
        return nearestAirport;
    }

    public List<Tickets> getListOfTickets() {
        return listOfTickets;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passengerId=" + passengerId +
                ", ticketsCount=" + ticketsCount +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nearestAirport='" + nearestAirport + '\'' +
                ", listOfTickets=" + listOfTickets +
                '}';
    }
}
