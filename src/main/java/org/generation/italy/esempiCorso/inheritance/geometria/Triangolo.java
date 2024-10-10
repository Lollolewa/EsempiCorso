package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{
    public Triangolo(int altezza,int base) {
        super(altezza, base);

    }

    @Override
    public int calcolaArea(){
        return base*altezza/2;
    }

}
