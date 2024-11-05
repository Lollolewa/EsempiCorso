package org.generation.italy.esempiCorso.sql2.model;

public class Tickets {
    private int ticketId;
    private String ticketCode;;
    private Passengers passengers;

    public Tickets(int ticketId, String ticketCode, Passengers passengers) {
        this.ticketId = ticketId;
        this.ticketCode = ticketCode;
        this.passengers = passengers;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", ticketCode='" + ticketCode + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
