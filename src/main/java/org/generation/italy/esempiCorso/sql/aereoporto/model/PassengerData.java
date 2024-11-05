package org.generation.italy.esempiCorso.sql.aereoporto.model;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;

public class PassengerData {
    private Passenger passenger;
    private int numFlights;

    public PassengerData(Passenger passenger, int numFlights) {
        this.passenger = passenger;
        this.numFlights = numFlights;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getNumFlights() {
        return numFlights;
    }

}
