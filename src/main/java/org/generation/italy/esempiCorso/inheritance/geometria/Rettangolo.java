package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma {

    public Rettangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public double calcolaArea() {
        return base * altezza;
    }
}
