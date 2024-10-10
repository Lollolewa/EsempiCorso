package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    private String name;
    public Triangolo (String name, int base, int altezza){
        super(base, altezza);
        this.name = name;
    }
    @Override
    public int calcolaArea(){
        return (base*altezza)/2;
    }
}







