package org.generation.italy.esempiCorso.inheritance.geometria;

public class Forma {
    protected int base,altezza;
    public Forma(int base, int altezza){
        this.base = base;
        this.altezza = altezza;
    }
    protected int calcoloArea() {
        return base * altezza;
    }
    public String toString(){
        return "La base di questa forma è " + base + ", l'altezza è " + altezza + ", l'area è: " + calcoloArea();
    }
}
