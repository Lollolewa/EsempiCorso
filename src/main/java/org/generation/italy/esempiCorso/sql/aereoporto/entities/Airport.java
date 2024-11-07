package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.WithId;

import java.util.ArrayList;
import java.util.List;

public class Airport implements WithId {
    private int id;
    private String name;
    private List<Passenger> passengers;
    //quando facciamo più di un costruttore, possiamo richiamarli, senza dover ripetere codice
//   public Airport(int id, String name) {
//      this(id, name, new ArrayList<>());  //this() invochiamo un altro costruttore
//    }

    //quando facciamo più di un costruttore, possiamo richiamarli, senza dover ripetere codice
    public Airport(int id, String name) {
        this(id, name, new ArrayList<>());  //this() invochiamo un altro costruttore
    }

    public Airport(int id, String name, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
