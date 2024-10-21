package org.generation.italy.travelAgency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Voyage {
    private int id;
    private double price;
    private LocalDate startDate, endDate;
    private Category category;
    private List<Destination> destinations;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Voyage(int id, double price, LocalDate startDate, LocalDate endDate, Category category, List<Destination> destinations) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.destinations = destinations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setDateOfStart(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Destination> getDestination() {
        return destinations;
    }

    public void setDestination(List<Destination> destination) {
        this.destinations = destination;
    }

    public int destinations() {
        return destinations.size();
    }

    @Override
    public String toString() {
        String tempString = "";
        for(Destination d : destinations) {
            tempString += d.toString();
        }
        return tempString + String.format("\nId: %d\nPrice: %.2f\nGiorno di partenza:\n%s\nGiorno del rientro\n%s\n\n",
                id, price,startDate.format(formatter), endDate.format(formatter));
    }
}

