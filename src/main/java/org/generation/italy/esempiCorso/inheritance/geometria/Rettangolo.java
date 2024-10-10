package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma {
    public Rettangolo(int base, int altezza){
        super(base,altezza);
    }
    @Override
    protected int calcoloArea() {
        return base * altezza;
    }
    @Override
    public String toString(){
        return "La base di questo rettangolo è " + base + ", l'altezza è " + altezza + ", l'area è: " + calcoloArea();
    }
}
