package org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte;

public class Scultura extends OperaDArte {
    int altezza, larghezza, profondita;

    public Scultura(String autore, String titolo, int altezza, int larghezza, int profondita) {
        super(autore, titolo);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = profondita;
    }
    @Override
    public double calculateDimensioni() {
        return altezza * larghezza* profondita;
    }

    @Override
    public String toString() {
        return "Scultura: Autore " + autore + " Titolo " + titolo + ", Dimensioni: " + calculateDimensioni();
    }
    public int getAltezza() {
        return altezza;
    }
    public int getLarghezza() {
        return larghezza;
    }
    public int getProfondita() {
        return profondita;
    }
}

