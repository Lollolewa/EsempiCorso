package org.generation.italy.esempiCorso.ravenclaw.sql.airport.model;

public class Tickets {
    private int id, passenger_id;
    private String code;

    public Tickets(int id, int passenger_id, String code) {
        this.id = id;
        this.passenger_id = passenger_id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", passenger_id=" + passenger_id +
                ", code='" + code + '\'' +
                '}';
    }
}