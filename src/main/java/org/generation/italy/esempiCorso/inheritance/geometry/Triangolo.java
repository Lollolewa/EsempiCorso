package org.generation.italy.esempiCorso.inheritance.geometry;

import org.generation.italy.esempiCorso.inheritance.geometria.Forma;

public class Triangolo extends Forma {


public Triangolo(int base,int altezza){
    super (base,altezza);
}
@Override
    public int calcolaArea() {
    int area = base*altezza/2;
    return area;

}
}

