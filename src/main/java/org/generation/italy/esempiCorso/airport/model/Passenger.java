package org.generation.italy.esempiCorso.airport.model;

import java.util.List;

public class Passenger {
    private long passengerID;
    private String passengerName;
    private String passengerSurname;
    private Airport nearestAirport;
    private List<Ticket> tickets;

    public Passenger(String passengerName, String passengerSurname, Airport nearestAirport) {
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.nearestAirport = nearestAirport;
    }

    public long getPassangerID() {
        return passengerID;
    }

    public String getPassangerName() {
        return passengerName;
    }

    public String getPassangerSurname() {
        return passengerSurname;
    }

    public Airport getPassangersAirport() {
        return nearestAirport;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setId(long id) {
        this.passengerID = passengerID;
    }

    @Override
    public String toString() {
        return "name: " + passengerName + "\n" +
                "surname: " + passengerSurname + "\n" +
                "airport: " + nearestAirport.getAirportName() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Passenger passenger = (Passenger) obj;
        return passengerID == passenger.passengerID &&
                passengerName.equals(passenger.passengerName) &&
                passengerSurname.equals(passenger.passengerSurname);
    }


    @Override
    public int hashCode() {
        return Long.hashCode(passengerID); // Restituisce l'hash dell'ID
    }
}

//un passengero e'una cosa che ha un id numerico , un nome , un aereoporto di riferimento,
//e una lista di tickets,
