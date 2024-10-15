package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma {

    public Rettangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public int calcolaArea() {
        return base * altezza;
    }

    @Override
    public String toString() {
        return String.format("Il rettangolo con base: %d e altezza: %d %nHa un'area di: %d", base, altezza, calcolaArea());
    }
}

