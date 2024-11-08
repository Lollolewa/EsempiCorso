package org.generation.italy.esempiCorso.sql.aereoporto.model;

public class AirportPassengerCount {
    private int id;
    private String name;
    private int passengerCount;

    public AirportPassengerCount(int id, String name, int passengerCount) {
        this.id = id;
        this.name = name;
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
