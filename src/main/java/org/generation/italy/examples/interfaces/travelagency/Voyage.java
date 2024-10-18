package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.List;

public class Voyage {
    private List<Destination> destinations;
    private Category  categories; //inizializzazione enum dentro un oggetto;
    private int id, price,duration;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String description;

    public int getDuration() {
        return duration;
    }

    public Voyage(List<Destination> destinations, Category categories, int id, int price, LocalDate startingDate, LocalDate endingDate, String description, int duration) {
        this.destinations = destinations;
        this.categories = categories;
        this.id = id;
        this.price = price;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.description = description;
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public Category getCategories() {
        return categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
}



