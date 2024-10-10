package org.generation.italy.esempiCorso.inheritance.geometry;

public class Triangolo extends Forma{

    public Triangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public int calculateArea() {
        int area = getBase() * getAltezza() / 2;
        return area;
    }
    @Override
    public String toString() {
        int area = calculateArea();
        return "la tua area è: " + area;
    }
}
