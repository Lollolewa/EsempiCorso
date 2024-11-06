package org.generation.italy.esempiCorso.sql.aereoporto.services;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;

public class InMemoryReservationService implements AbstractReservationService {
    @Override
    public Ticket createReservation(int passengerId) {
        return null;
    }

    @Override
    public Passenger findPassengerByTicketCode(String code, String passengerName) {
        return null;
    }
}
