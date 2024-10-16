package org.generation.italy.esempiCorso.Slytherin.exercises.OperaDArte;

public class Scultura extends OperaDArte {
    int altezza;
    int larghezza;
    int profondità;

    public Scultura(String titolo, String artista, int altezza, int larghezza, int profondità) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
    }

    @Override
    public double printingombro() {
        return this.altezza * this.larghezza * this.profondità;
    }
}
