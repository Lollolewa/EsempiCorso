package org.generation.italy.esempiCorso.inheritance.geometry;

public class Rettangolo extends Forma{

    public Rettangolo (int base, int altezza){
        super(base, altezza);
    }
    @Override
        public int calcolaArea(){
        int area = base * altezza;
        return area;
    }
}
