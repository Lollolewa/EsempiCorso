package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.entity.Passenger;
import org.generation.italy.esempiCorso.airportManagement.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    private static int passengerIdCounter = 1; // Contatore per gli ID dei passeggeri
    private static int ticketIdCounter = 0; // Contatore per gli ID dei biglietti

    public static List<Passenger> initializePassengers(List<Ticket> initialTickets) {
        List<Passenger> passengers = new ArrayList<>();

        passengers.add(new Passenger(passengerIdCounter++, "John", "Doe", 1, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Jane", "Smith", 2, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Emily", "Jones", 1, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Michael", "Johnson", 3, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Sarah", "Williams", 2, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "David", "Brown", 4, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Laura", "Davis", 5, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "James", "Miller", 6, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Linda", "Wilson", 1, new ArrayList<>()));
        passengers.add(new Passenger(passengerIdCounter++, "Robert", "Moore", 7, new ArrayList<>()));

        return passengers;
    }

    public static List<Ticket> initializeTickets(List<Passenger> passengers) {
        List<Ticket> tickets = new ArrayList<>();


        tickets.add(new Ticket(ticketIdCounter++, "TICKET001", passengers.get(0).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET002", passengers.get(0).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET003", passengers.get(1).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET004", passengers.get(2).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET005", passengers.get(3).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET006", passengers.get(4).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET007", passengers.get(1).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET008", passengers.get(5).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET009", passengers.get(6).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET010", passengers.get(7).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET011", passengers.get(8).getPsgid()));
        tickets.add(new Ticket(ticketIdCounter++, "TICKET012", passengers.get(9).getPsgid()));


        return tickets;
    }
}

