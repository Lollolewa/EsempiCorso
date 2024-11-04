package org.generation.italy.esempiCorso.airportManagement.dao;

import org.generation.italy.esempiCorso.airportManagement.model.Passenger;
import org.generation.italy.esempiCorso.airportManagement.model.Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PassengerDaoInMemory implements PassengerDao {
    private List<Passenger> passengers;

    public PassengerDaoInMemory(List<Passenger> passengers) {
        this.passengers = passengers != null ? passengers : new ArrayList<>();
    }

    @Override
    public List<Ticket> getPsgTicketsById(int id) throws DaoException {
        // Cerca il passeggero per ID e restituisce i biglietti associati
        return passengers.stream()
                .filter(p -> p.getPsgid() == id)
                .flatMap(p -> p.getTickets().stream())
                .toList();
    }

    @Override
    public void printPsgByNumTickets() throws DaoException {
        // Ordina i passeggeri per numero di biglietti e stampa ogni passeggero
        passengers.stream()
                .sorted(Comparator.comparingInt((Passenger p) -> p.getTickets().size()))
                .forEach(System.out::println);
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        // Rimuove il passeggero con l'ID specificato
        return passengers.removeIf(p -> p.getPsgid() == id);
    }

    public Optional<Passenger> getPassengerById(int id) {
        // Trova e restituisce il passeggero con l'ID specificato
        return passengers.stream()
                .filter(p -> p.getPsgid() == id)
                .findFirst();
    }
}
