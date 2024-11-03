package org.generation.italy.esempiCorso.ravenclaw.sql.model;

import java.util.List;

public class Airport {
    private int id;
    private String name;
    private List<Passenger> passengers;

    public Airport(int id, String name, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.passengers = passengers;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
