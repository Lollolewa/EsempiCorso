package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
    public Rettangolo(int base, int altezza){
        super(base, altezza);
    }

    @Override
    public int calcolaArea() {
        return base*altezza;
    }

    @Override
    public String toString(){
        return "Rettangolo con base: " + base + " e altezza: "+ altezza +" ha un'area di: " + calcolaArea();
    }
}
