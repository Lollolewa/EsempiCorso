package org.generation.italy.esempiCorso.airportManagement.entity;

public class Ticket {
    private int tickid;
    private String code;
    private int psgid; // sarebbe meglio se prendesse direttamente un passeggero, non solo il suo id

    public Ticket(int tickid, String code, int psgid) {
        this.tickid = tickid;
        this.code = code;
        this.psgid = psgid;
    }

    public int getTickid() {
        return tickid;
    }

    public String getCode() {
        return code;
    }

    public int getPsgid() {
        return psgid;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tickid=" + tickid +
                ", code=" + code +
                '}';
    }
}
