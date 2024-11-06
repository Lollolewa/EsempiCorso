package org.generation.italy.esempiCorso.sql.aereoporto.entities;

public class Ticket {
    private int id;
    private String code;
    private Passenger passenger;

    public Ticket(int id,String code, Passenger passenger) {
        this.id = id;
        this.code = code;
        this.passenger=passenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
