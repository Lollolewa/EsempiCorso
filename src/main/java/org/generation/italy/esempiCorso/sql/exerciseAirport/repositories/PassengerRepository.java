package org.generation.italy.esempiCorso.sql.exerciseAirport.repositories;

import org.generation.italy.esempiCorso.sql.exerciseAirport.model.Passenger;

import java.util.List;

public interface PassengerRepository {
    List<Passenger> getPassengersOrderByNumFlights();
    boolean deleteById(long id);
}
