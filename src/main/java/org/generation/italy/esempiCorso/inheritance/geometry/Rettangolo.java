package org.generation.italy.esempiCorso.inheritance.geometry;

public class Rettangolo extends Forma{

    public Rettangolo(int base, int altezza) {
        super(base , altezza);
    }
    @Override
    public int calculateArea() {
        int area = getBase() * getAltezza();
        return area;
    }
    @Override
    public String toString() {
        int area = calculateArea();
        return "la tua area è: " + area;
    }
}
