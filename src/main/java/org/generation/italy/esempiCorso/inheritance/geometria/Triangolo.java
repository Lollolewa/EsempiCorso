package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{

    public Triangolo(int base, int altezza){
        super(base, altezza);
    }

    @Override
    public int calcolaArea(){
        return (base*altezza) / 2;
    }

    @Override
    public String toString(){
        return "Triangolo con base: " + base + " e altezza: "+ altezza +" ha un'area di: " + calcolaArea();
    }
}
