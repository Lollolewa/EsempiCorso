package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.entity.Passenger;
import org.generation.italy.esempiCorso.airportManagement.entity.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoInMemory implements TicketDao {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Passenger> passengers;

    public TicketDaoInMemory(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public Optional<Ticket> getTicketByCode(String code) throws DaoException {
        return tickets.stream()
                .filter(t -> t.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    @Override
    public Ticket addTicketToPsg(String code, int psgid) throws DaoException {
        boolean passengerExists = passengers.stream()
                .anyMatch(p -> p.getPsgid() == psgid);
        if (!passengerExists) {
            throw new DaoException("Passenger not found");
        }
        Ticket newTicket = new Ticket(tickets.size(), code, psgid);
        tickets.add(newTicket);
        return newTicket;
    }
}

