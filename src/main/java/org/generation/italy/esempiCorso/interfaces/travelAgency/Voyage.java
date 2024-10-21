package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Voyage {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public Category getCategories() {
        return categories;
    }
    @Override
    public String toString(){
        String temp = "";
        for (Destination d : destinationList) {
            temp += d.toString();
        }
        return temp += String.format("==============================%n" +
                "ID: %d%nPrezzo %f%nData di inizio: %s%nData di fine %s%nCategoria %s%n==============================%n%n%n"
                , id, price, startDate.format(formatter), endDate.format(formatter), categories);
    }
}
