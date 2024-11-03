package org.generation.italy.esempiCorso.ravenclaw.sql.model;

import java.util.List;

public class Passenger {
    private String name, surname;
    private int id, airport_id;
    private List<Ticket> tickets;

    public Passenger(String name, String surname, int id, int airport_id, List<Ticket> tickets) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.airport_id = airport_id;
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
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
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", airport_id=" + airport_id +
                ", tickets=" + tickets +
                '}';
    }
}
