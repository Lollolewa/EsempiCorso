package org.generation.italy.esempiCorso.sql2.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    int airportId;
    String airportName;
    List<Passengers> listOfPassengers = new ArrayList<>();

    public Airport(int airportId, String airportName, List<Passengers> listOfPassengers) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.listOfPassengers = listOfPassengers;
    }

    public int getAirportId() {
        return airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public List<Passengers> getListOfPassengers() {
        return listOfPassengers;
    }

    @Override
    public String toString() {
        return "Airport{" +
                ", airportName='" + airportName + '\'' +
                ", airportId=" + airportId +
                '}';
    }
}
