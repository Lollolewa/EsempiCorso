package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.List;

public class Voyage {
    private int id;
    private int  price;
    private LocalDate sDate;
    private LocalDate eDate;
    private Category category;
    private List<Destination> destinations;
    private String name;

    public Voyage(List<Destination> destinations, Category category, LocalDate eDate, LocalDate sDate, int price, int id, String name) {
        this.destinations = destinations;
        this.category = category;
        this.eDate = eDate;
        this.sDate = sDate;
        this.price = price;
        this.id = id;
        this.name = name;
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

    public LocalDate getsDate() {
        return sDate;
    }

    public void setsDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;

    }
}
