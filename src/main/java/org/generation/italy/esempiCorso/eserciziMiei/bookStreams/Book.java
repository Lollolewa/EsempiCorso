package org.generation.italy.esempiCorso.eserciziMiei.bookStreams;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private int id, numPages;
    private String title, language;
    private double peso, costo;
    private LocalDate dataPubblicazione;
    private List<Author> authors;
    private Category categoria;

    public Book(int id, int numPages, String title, String language, double peso, double costo, LocalDate dataPubblicazione, List<Author> authors, Category categoria) {
        this.id = id;
        this.numPages = numPages;
        this.title = title;
        this.language = language;
        this.peso = peso;
        this.costo = costo;
        this.dataPubblicazione = dataPubblicazione;
        this.authors = authors;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public int getNumPages() {
        return numPages;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public double getPeso() {
        return peso;
    }

    public double getCosto() {
        return costo;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Category getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format("Libro:%nid: %d%nNumero Pagine: %d%nTitolo: %s%nLingua: %s%nPeso: %.2f%nCosto: %.2f%nDataPubblicazione: %s%nAutori: %s%nCategoria: %s", id, numPages, title, language, peso, costo, dataPubblicazione, authors, categoria);
    }
}
