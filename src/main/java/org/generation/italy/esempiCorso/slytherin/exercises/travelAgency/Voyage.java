package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

import java.time.LocalDate;
import java.util.List;

public class Voyage implements Comparable<Voyage> {
    //list di destination
    private List<Destination> destinations;
    private int id;
    private double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private Category category;
    private int countDaysOfVoyage;

    public Voyage(List<Destination> destinations, int id, double price, LocalDate startDate, Category category) {
        this.destinations = destinations;
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.category = category;
        this.countDaysOfVoyage = destinations.isEmpty() ? +1 : 0;
        for (Destination destination : destinations) {
            countDaysOfVoyage += destination.getNumberOfDays();
        }
        this.endDate = startDate.plusDays(countDaysOfVoyage);
    }
    public List<Destination> getDestinations() {
        return destinations;
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

    public Category getCategory() {
        return category;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "destinations=" + destinations +
                ", id=" + id +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", category=" + category +
                '}';
    }
// Se scrivo int z = a1.compareTo(a2) ritorna un intero z
// Se z è negativo significa che a1 è minore di a2 (minore = viene prima)
// se è positivo significa che a1 è maggiore di a2 (maggiore = viene dopo)
// se è zero significa che a1 è uguale a2 (l'ordinamento è uguale)

    @Override
    public int compareTo(Voyage o) { // ordinamento naturale.
        return o.id-this.id; // return  per il contrario.
    }

    public int getDestinationsSize(){
        return this.destinations.size();
    }
}
