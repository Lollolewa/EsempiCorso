package org.generation.italy.examples.interfaces.travelagency;
import java.time.LocalDate;
import java.util.List;

public class Voyage {
    private List<Destination> destinations;
    private int id, prezzo;
    private LocalDate departure;
    private LocalDate arrival;
    private Category categoria;

    public Voyage(List<Destination> destinations, int id, int prezzo, LocalDate departure, LocalDate arrival, Category categoria) {
        this.destinations = destinations;
        this.id = id;
        this.prezzo = prezzo;
        this.departure = departure;
        this.arrival = arrival;
        this.categoria = categoria;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public int getId() {
        return id;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public Category getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "destinations=" + destinations +
                ", id=" + id +
                ", prezzo=" + prezzo +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", categoria=" + categoria +
                '}';
    }
}
