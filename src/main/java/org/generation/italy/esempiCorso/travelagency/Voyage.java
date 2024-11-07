package org.generation.italy.esempiCorso.travelagency;

import java.time.LocalDate;
import java.util.List;

public class Voyage implements Comparable<Voyage>{
    private List<Destination> destinations;
    private int id;
    private double price;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Category category;

    public Voyage(List<Destination> destinations, double price, LocalDate dataInizio, LocalDate dataFine, Category category) {
        this.destinations = destinations;
        this.price = price;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.category = category;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString() {
        return String.format("Il viaggio ha le seguenti destinazioni: %s \n ID viaggio: %s \n " +
                "Prezzo viaggio: %s \n Data partenza: %s \n Data ritorno: %s \n Categoria: %s \n",
                destinations, id, price, dataInizio, dataFine, category);
    }

    @Override
    /*se scrivo int z= a1.compareTo(a2) ritorna un intero z
    se z è negativo significa che a1 + minore di a2 (minore = viene prima)
    se è positivo significa che a1 è magigore di a2 (maggiore = viene dopo)
    se è zero significa che a1 è uguale a a2(l'ordine è uguale) */
    public int compareTo(Voyage o) {
        return this.id-o.id; //cosi ordina dal minore al maggiore, o.ID-this.ID ordina dal maggiore al minore
    }
    public int getDestionationsSize(){
        return this.destinations.size();
    }
}
