package org.generation.italy.esempiCorso.eserciziStream;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private int id;
    private String titolo;
    private double peso;
    private int pagine;
    private double costo;
    private LocalDate dataPubblicazione;
    private Category categoria;
    private List<Autore> autori;
    private String lingua;

    public Book(int id, String titolo, double peso, int pagine, double costo, LocalDate dataPubblicazione, Category categoria, List<Autore> autori, String lingua) {
        this.id = id;
        this.titolo = titolo;
        this.peso = peso;
        this.pagine = pagine;
        this.costo = costo;
        this.dataPubblicazione = dataPubblicazione;
        this.categoria = categoria;
        this.autori = autori;
        this.lingua = lingua;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public double getPeso() {
        return peso;
    }

    public int getPagine() {
        return pagine;
    }

    public double getCosto() {
        return costo;
    }

    public LocalDate getDataPubblicazione() {
        return dataPubblicazione;
    }

    public Category getCategoria() {
        return categoria;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public String getLingua() {
        return lingua;
    }

}
