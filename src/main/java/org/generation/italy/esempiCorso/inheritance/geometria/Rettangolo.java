package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
    private String name;
    private int nLati;
    public Rettangolo(int base, int altezza, String name, int nLati){
        super(base, altezza);
        this.name=name;
        this.nLati=nLati;
    }

    public String getName(){
        return name;
    }
    public int getnLati(){
        return nLati;
    }

    @Override
    public int calculateArea() {
        return base*altezza;
    }
}
