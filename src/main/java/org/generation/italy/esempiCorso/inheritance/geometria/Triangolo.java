package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma {
    public Triangolo(int base, int altezza){
        super(base,altezza);
    }
    @Override
    protected int calcoloArea() {
        return base * altezza/2;
    }
    @Override
    public String toString(){
        return "La base di questo triangolo è " + base + ", l'altezza è " + altezza + ", l'area è: " + calcoloArea();
    }
}
