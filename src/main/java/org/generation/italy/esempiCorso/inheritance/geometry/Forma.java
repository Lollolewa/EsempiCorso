package org.generation.italy.esempiCorso.inheritance.geometria;

public class Forma {
    protected int base, altezza;

    public Forma(int base, int altezza){
        this.base = base;
        this.altezza = altezza;
    }
    public int calcolaArea(int base, int altezza){
        return 0;
    }

    public String toString(){
        return "L'area del ";
    }
}
