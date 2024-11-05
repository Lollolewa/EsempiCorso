package org.generation.italy.esempiCorso.eserciziMiei.aeroporto.model;

import org.generation.italy.esempiCorso.eserciziMiei.aeroporto.entities.Passeggero;

public class PassengerData {
    private Passeggero passenger;
    private int numFlights;

    public PassengerData(Passeggero passenger, int numFlights) {
        this.passenger = passenger;
        this.numFlights = numFlights;
    }

    public Passeggero getPassenger() {
        return passenger;
    }

    public int getNumFlights() {
        return numFlights;
    }
}
