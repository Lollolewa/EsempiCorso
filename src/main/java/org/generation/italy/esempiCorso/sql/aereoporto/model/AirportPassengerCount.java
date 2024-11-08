package org.generation.italy.esempiCorso.sql.aereoporto.model;

public class AirportPassengerCount {

    private int id, passengerCount;
    private String name;

    public AirportPassengerCount(int id, int passengerCount, String name) {
        this.id = id;
        this.passengerCount = passengerCount;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public String getName() {
        return name;
    }
}
