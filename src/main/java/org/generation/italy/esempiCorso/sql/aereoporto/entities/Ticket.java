package org.generation.italy.esempiCorso.sql.aereoporto.entities;

import jakarta.persistence.*;
import org.generation.italy.esempiCorso.sql.aereoporto.daos.templates.WithId;

@Entity
@Table(name = "ticket")
public class Ticket implements WithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "codice")
    private String code;

    @ManyToOne
    @JoinColumn(name = "passeggero_id")
    private Passenger passenger;

    public Ticket(){
    }

    public Ticket(int id, String code) {
        this.id = id;
        this.code = code;
    }
    public Ticket(int id, String code, Passenger p){
        this(id,code);
        this.passenger = p;
    }

    public String getCode() {
        return this.code;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}