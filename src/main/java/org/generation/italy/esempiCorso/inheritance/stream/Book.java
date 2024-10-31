package org.generation.italy.esempiCorso.inheritance.stream;

import java.util.List;

public class Book {
    private int id;
    private String titolo, lingua;
    private Category categoria;
    private int peso, numeroPagine, dataPubblicazione;
    private double costo;
    private List<Author> authors;

    public Book(String titolo, String lingua, Category categoria, int peso, int numeroPagine, int dataPubblicazione, double costo, List<Author> authors) {
        this.titolo = titolo;
        this.lingua = lingua;
        this.categoria = categoria;
        this.peso = peso;
        this.numeroPagine = numeroPagine;
        this.dataPubblicazione = dataPubblicazione;
        this.costo = costo;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }
    public int getNumberOfAuthors() {
        return authors.size(); // Supponendo che 'autori' sia la lista di autori
    }

    public String getTitolo() {
        return titolo;
    }

    public String getLingua() {
        return lingua;
    }

    public Category getCategoria() {
        return categoria;
    }

    public int getDataPubblicazione() {
        return dataPubblicazione;
    }

    public double getCosto() {
        return costo;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", lingua='" + lingua + '\'' +
                ", categoria='" + categoria + '\'' +
                ", peso=" + peso +
                ", numeroPagine=" + numeroPagine +
                ", dataPubblicazione=" + dataPubblicazione +
                ", costo=" + costo +
                ", author=" + authors +
                '}';
    }
}



//Creare una classe Book che ha come stato:

//id numerico
//titolo
//peso
//numero pagine
//costo
//data pubblicazione
//categoria
//lista di autori
//lingua