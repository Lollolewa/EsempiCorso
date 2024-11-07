package org.generation.italy.esempiCorso.ravenclaw.sql.airport.model;
import java.util.List;

public class Passengers {
    private int id, airport_id;
    private String name, surname;
    private List<Tickets> ticket;

    public Passengers(int id, int airport_id, String name, String surname, List<Tickets> ticket) {
        this.id = id;
        this.airport_id = airport_id;
        this.name = name;
        this.surname = surname;
        this.ticket = ticket;
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

    public List<Tickets> getTicket() {
        return ticket;
    }

    public void setTicket(List<Tickets> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "id=" + id +
                ", airport_id=" + airport_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
