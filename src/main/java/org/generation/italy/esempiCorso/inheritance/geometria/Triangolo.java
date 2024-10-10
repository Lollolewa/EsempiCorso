package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    public Triangolo(int base, int altezza){
       super(base, altezza);
    }

    @Override
    public int calcolaArea() {
        int area = (base*altezza)/2;
        return area;
    }

    @Override
    public String toString() {
        return "L'area e' " + calcolaArea();
    }
}
