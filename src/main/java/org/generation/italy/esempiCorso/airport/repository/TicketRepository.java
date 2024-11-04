package org.generation.italy.esempiCorso.airport.repository;

import org.generation.italy.esempiCorso.airport.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    Optional<Ticket> searchTicketByCode(String code) throws Exception;
    List<Ticket> getPassengersTikets(int passengerID) throws Exception;
    Ticket createNewPassengerTicket(String code, int passengerID) throws Exception;
}
