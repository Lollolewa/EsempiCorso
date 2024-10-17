package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Voyage {
    private List<Destination> destinations;
    private Category  categories; //inizializzazione enum dentro un oggetto;
    private int id, price;
    private LocalDate startingDate;
    private LocalDate endingDate;
    public Voyage(List<Destination> destinations, Category categories, int id, int price, LocalDate startingDate, LocalDate endingDate) {
        this.destinations = destinations;
        this.categories = categories;
        this.id = id;
        this.price = price;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }


}



