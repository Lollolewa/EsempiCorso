package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma {
    Rettangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    double calcolaArea() {
        return (double) base * altezza;
    }
}
