package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import jakarta.persistence.*;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.WithId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Table( name = "aeroporto")
@Entity //classe gestita da hibernate
public class Airport implements WithId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autogenerato
    private int id;
    @Column(name = "nome")
    private String name;
    public Airport(){ //costruttore di default

    }
    @OneToMany(mappedBy = "nearestAirport")// airport e' il nome della variabile che sta dall'altra parte della relazione
    // in base al tipo di relazione
    private List<Passenger> passengers = new ArrayList<>();

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

