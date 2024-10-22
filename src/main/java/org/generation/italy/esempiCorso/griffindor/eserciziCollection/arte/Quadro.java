package org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte;

public class Quadro extends OperaDArte {
    int altezza, larghezza;
    int profondita;

    public Quadro(String autore, String titolo, int altezza, int larghezza) {
        super(autore, titolo);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = 1;
    }
    @Override
    public double calculateDimensioni() {
        return altezza * larghezza;
    }
    public String toString() {
        return "Quadro: Autore " + autore + " Titolo " + titolo + ", Dimensioni: " + calculateDimensioni();
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
