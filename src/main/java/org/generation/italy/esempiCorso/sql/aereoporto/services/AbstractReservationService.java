package org.generation.italy.esempiCorso.sql.aereoporto.services;

import org.generation.italy.esempiCorso.sql.aereoporto.entities.Passenger;
import org.generation.italy.esempiCorso.sql.aereoporto.entities.Ticket;

public interface AbstractReservationService {
    Ticket createReservation(int passengerId);
    Passenger findPassengerByTicketCode(String code, String passengerName);
}
