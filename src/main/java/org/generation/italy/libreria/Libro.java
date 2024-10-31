package org.generation.italy.libreria;

public class Libro {
    private String titolo, autore;
    private int annoPubblicazione;

    public Libro(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }
    public String toString(){
        String books = this.titolo + "\n" + this.autore + "\n" + this.annoPubblicazione;
        return books;
    }
}


/*Crea una classe Libro:

Attributi: titolo (String), autore (String), annoPubblicazione (int).
Costruttore per inizializzare questi attributi.
Un metodo toString() per restituire una rappresentazione testuale del libro.*/