package org.generation.italy.esempiCorso.inheritance.geometria;

public class Triangolo extends Forma{

    //creo il costruttore aggiungendo le variabili della classe madre con super
    public Triangolo(int base, int altezza){
        super(base, altezza);
    }

    @Override
    public int calcolaArea(int base, int altezza) {
        return (base*altezza)/2;
    }

    @Override
    public String toString(){
        return String.format("%sTriangolo e' uguale a %d.", super.toString(), calcolaArea(base, altezza));
    }
}
