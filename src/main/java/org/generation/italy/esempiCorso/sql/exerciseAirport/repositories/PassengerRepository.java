package org.generation.italy.esempiCorso.sql.exercises.airport.repositories;

import org.generation.italy.esempiCorso.sql.exercises.airport.model.Passenger;

import java.util.List;

public interface PassengerRepository {
    List<Passenger> getPassengersOrderByNumFlights();
    boolean deleteById(long id);
}
