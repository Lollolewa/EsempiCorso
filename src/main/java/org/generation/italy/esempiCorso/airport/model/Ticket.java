package org.generation.italy.esempiCorso.airport.model;


public class Ticket {
    private long ticketID;
    private String code;
    private int passengerID; //NO
    private Passenger passenger;

    public Ticket(String code, int passengerID, Passenger passenger) {
        this.code = code;
        this.passengerID = passengerID;
        this.passenger = passenger;
    }

    public long getTicketID() {
        return ticketID;
    }

    public String getCode() {
        return code;
    }

    public Passenger getPassanger() {
        return passenger;
    }

    public void setId(long id) {
    }

    @Override
    public String toString() {
        return "Ticket code: " + code + "\n" +
                "passengerID: " + passengerID + "\n";
    }
}
//un ticket ha un id numerico, una stringa che e' il suo codice,
// e un riferimento al passengero a cui appartiene