package org.generation.italy.esempiCorso.ravenclaw.sql.airport.model;

import java.util.List;

public class Passenger {
    private String name, surname;
    private int id, airport_id;

    public Passenger(String name, String surname, int id, int airport_id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
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



    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", airport_id=" + airport_id +
                '}';
    }
}
