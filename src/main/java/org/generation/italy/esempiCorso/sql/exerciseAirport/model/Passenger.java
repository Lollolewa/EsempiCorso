package org.generation.italy.esempiCorso.sql.exerciseAirport.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table( name = "passeggero")
public class Passenger {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "nome")
    private String name;
    @ManyToOne
    @JoinColumn( name = "aeroporto_id") //specica la foreign key
    private Airport airport;
    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(){
    }
    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

}
