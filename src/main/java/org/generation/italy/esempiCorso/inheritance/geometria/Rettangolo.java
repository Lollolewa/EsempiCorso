package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
    public Rettangolo(double base, double altezza){
        super(base, altezza);
    }

    @Override
    public double calcolaArea() {
        return base * altezza;
    }
}
