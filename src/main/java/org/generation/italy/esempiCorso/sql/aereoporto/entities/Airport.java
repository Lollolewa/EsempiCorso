package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import jakarta.persistence.*;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.WithId;

import java.util.ArrayList;
import java.util.List;
@Table (name = "aeroporto")
@Entity
public class Airport implements WithId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID viene autogenerato
    private int id;
    @Column(name = "nome")
    private String name;
    @OneToMany // spiega che tipo di relazione c'e
    private List<Passenger> passengers;
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
