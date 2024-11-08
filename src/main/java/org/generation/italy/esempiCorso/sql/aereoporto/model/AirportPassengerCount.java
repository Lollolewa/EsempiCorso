package org.generation.italy.esempiCorso.sql.aereoporto.model;

public class AirportPassengerCount {
    //classe costum;
    private int id, passengerCount;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirportPassengerCount(int id, int passengerCount, String name) {
        this.id = id;
        this.passengerCount = passengerCount;
        this.name = name;
    }
}
