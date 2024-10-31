package org.generation.italy.esempiCorso.lambdaStreams;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private int id;
    private String titolo;
    private double peso;
    private int numeroPagine;
    private double costo;
    private LocalDate dataPubblicazione;
    private Category categoria;
    private List<Author> autori;
    private String lingua;

    public Book(int id, String titolo, double peso, int numeroPagine, double costo, LocalDate dataPubblicazione, Category categoria, List<Author> autori, String lingua) {
        this.id = id;
        this.titolo = titolo;
        this.peso = peso;
        this.numeroPagine = numeroPagine;
        this.costo = costo;
        this.dataPubblicazione = dataPubblicazione;
        this.categoria = categoria;
        this.autori = autori;
        this.lingua = lingua;
    }

    public double getCosto() {
        return costo;
    }

    public List<Author> getAutori() {
        return autori;
    }

    public String getLingua() {
        return lingua;
    }

    public Category getCategoria() {
        return categoria;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }


    public boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate));
    }

    public int getNumberAuthors() {
        return autori.size();
    }

    public int getPages() {
        return numeroPagine;
    }

    @Override
    public String toString() {
        return String.format("Book \n" +
                "   ID: %d \n" +
                "   Titolo: '%s' \n" +
                "   Peso: %.2f kg \n" +
                "   Numero di Pagine: %d \n" +
                "   Costo: %.2f€ \n" +
                "   Data di Pubblicazione: %s \n" +
                "   Categoria: %s \n" +
                "   Autori: %s \n" +
                "   Lingua: '%s' \n",
                id, titolo, peso, numeroPagine, costo, dataPubblicazione, categoria, autori, lingua);
    }
}