package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{

    public Rettangolo(int altezza ,int base) {
        super( altezza, base);
        this.base = base;
        this.altezza = altezza;
    }
    @Override
    public int calcolaArea(){
        return base*altezza;

    }




}
