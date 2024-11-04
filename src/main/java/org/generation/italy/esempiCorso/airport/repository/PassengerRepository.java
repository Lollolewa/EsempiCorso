package org.generation.italy.esempiCorso.airport.repository;

import org.generation.italy.esempiCorso.airport.model.Passenger;

import java.util.HashMap;

public interface PassengerRepository {
    List<PassengerData> findAllOrderByNumTickets() throws Exception;
    boolean deletePassengerByID(int id) throws Exception;
}
