package org.generation.italy.esempiCorso.airportManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private int airpid;
    private String name;
    private List<Passenger> passengers = new ArrayList<>();

    public Airport(int airpid, String name, List<Passenger> passengers) {
        this.airpid = airpid;
        this.name = name;
        this.passengers = passengers;
    }

    public int getAirpid() {
        return airpid;
    }

    public String getName() {
        return name;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airpid=" + airpid +
                ", name='" + name + '\'' +
                '}';
    }
}

