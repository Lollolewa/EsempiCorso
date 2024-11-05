package org.generation.italy.esempiCorso.sql.exercises.airport.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airport {


    private int id;
    private String name;

    private List<Passenger> passengers = new ArrayList<>();

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}

