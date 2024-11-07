package org.generation.italy.esempiCorso.sql.exerciseAirport.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "codice")
    private String code;
    @ManyToOne
    @JoinColumn(name = "passeggero_id")
    private org.generation.italy.esempiCorso.sql.exercises.airport.model.Passenger passenger;
    public Ticket(){

    }

    public Ticket(int id, String code) {
        this.id = id;
        this.code = code;
    }
}