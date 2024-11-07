package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import jakarta.persistence.*;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.WithId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table( name = "passeggero")
public class Passenger implements WithId {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn( name = "aeroporto_id") //specica la foreign key
    private Airport nearestAirport;


    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(){
    }
    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Passenger(int id, String name, Airport nearestAirport) {
        this(id, name, nearestAirport, new ArrayList<>());
    }

    public Passenger(int id, String name, Airport nearestAirport, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.nearestAirport = nearestAirport;
        this.tickets=tickets;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Airport getNearestAirport() {
        return this.nearestAirport;
    }
}
