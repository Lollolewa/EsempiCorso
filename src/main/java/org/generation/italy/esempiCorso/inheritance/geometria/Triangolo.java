package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{

    public Triangolo(int base, int altezza) {
        super(base, altezza);
    }

    @Override
    public int clacolaArea(){
        int area = base*altezza/2;
        return area;
    }

    @Override
    public String toString(){
        return String.format("Il triangolo con base: %d e altezza: %d %nHa un area di: %d", base,altezza,clacolaArea());
    }
}
