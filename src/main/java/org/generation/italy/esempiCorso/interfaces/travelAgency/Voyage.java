package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.time.LocalDate;
import java.util.List;

public class Voyage {
    private List<Destination> destinationList;
    private int id;
    private double price;
    private LocalDate startDate, endDate;
    private Category categories;

    public Voyage(List<Destination> destinationList, int id, double price, LocalDate startDate, LocalDate endDate, Category categories) {
        this.destinationList = destinationList;
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.categories = categories;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public Category getCategories() {
        return categories;
    }

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public void setCategories(Category categories) {
        this.categories = categories;
    }

}
