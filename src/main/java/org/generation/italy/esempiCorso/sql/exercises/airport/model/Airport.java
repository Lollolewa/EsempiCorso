package org.generation.italy.esempiCorso.sql.exercises.airport.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Table( name = "aeroporto")
@Entity //classe gestita da hibernate
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autogenerato
    private int id;

    @Column(name = "nome")
    private String name;
    public Airport(){ //costruttore di default
    }

    @OneToMany(mappedBy = "airport")// airport e' il nome della variabile che sta dall'altra parte della relazione
    // in base al tipo di relazione
    private List<Passenger> passengers = new ArrayList<>();

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}

