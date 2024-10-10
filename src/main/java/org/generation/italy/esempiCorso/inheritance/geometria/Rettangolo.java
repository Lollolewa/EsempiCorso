package org.generation.italy.esempiCorso.inheritance.geometria;


public class Rettangolo extends Forma{

public class Rettangolo extends Forma {


    public Rettangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override

    public int calcolaArea(){
        int area = base*altezza;
        return area;
    }

    @Override
    public String toString(){
        return String.format("Il rettangolo con base: %d e altezza: %d %nHa un area di: %d", base,altezza, calcolaArea());

    public double calcolaArea() {
        return base * altezza;

    }
}
