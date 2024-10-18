package org.generation.italy.esempiCorso.inheritance.geometry;

import org.generation.italy.esempiCorso.inheritance.geometria.Forma;

public class Rettangolo extends Forma {

    public Rettangolo (int base, int altezza){
        super(base, altezza);
    }
    @Override
        public int calcolaArea(){
        int area = base * altezza;
        return area;
    }
}
