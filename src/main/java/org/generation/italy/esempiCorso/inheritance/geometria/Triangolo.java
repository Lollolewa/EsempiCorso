package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    public Triangolo(double base, double altezza){
        super(base, altezza);
    }

    @Override
    public double calcolaArea() {
    return ((base * altezza) / 2);
    }
}
