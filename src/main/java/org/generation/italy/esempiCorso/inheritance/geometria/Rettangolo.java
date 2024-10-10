package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
    public Rettangolo(int base, int altezza ){
        super(base, altezza);
    }

    @Override
    public int calcolaArea(){
        int area = (base*2) + (altezza*2);
        return area;
    }

    @Override
    public String toString() {
        return "L'area e' " + calcolaArea();
    }
}
