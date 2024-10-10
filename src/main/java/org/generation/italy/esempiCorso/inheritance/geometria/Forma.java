package org.generation.italy.esempiCorso.inheritance.geometria;

public class Forma {
    protected double base, altezza;

    public Forma(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double calcolaArea(){
        double area = base * altezza;
        return calcolaArea();
    }

}
