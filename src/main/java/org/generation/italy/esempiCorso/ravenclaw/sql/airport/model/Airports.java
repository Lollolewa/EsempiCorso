package org.generation.italy.esempiCorso.ravenclaw.sql.airport.model;
import java.util.List;

public class Airports {
    private int id;
    private String name;
    private List<Passengers> passengers;

    public Airports(int id, String name, List<Passengers> passengers) {
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

    public List<Passengers> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passengers> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Airports{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
