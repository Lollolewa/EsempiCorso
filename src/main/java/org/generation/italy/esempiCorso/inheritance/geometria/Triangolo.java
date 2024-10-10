package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    public Triangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public double calcolaArea() {
        return (double) (base * altezza) / 2;
    }

}
