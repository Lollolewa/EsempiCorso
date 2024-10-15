package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma {

    public Triangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public int calcolaArea() {
        return (int) ((base * altezza) / 2.0);
    }

    @Override
    public String toString() {
        return String.format("Il triangolo con base: %d e altezza: %d %nHa un'area di: %.2f", base, altezza, calcolaArea());
    }
}

