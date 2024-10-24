package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    private String name;
    private int nLati;
    public Triangolo(int base, int altezza, String name, int nLati){
        super(base,altezza);
        this.name=name;
        this.nLati=nLati;
    }
    public String getName(){
        return name;
    }
    @Override
    public int calculateArea(){
        return base*altezza/2;
    }
}
