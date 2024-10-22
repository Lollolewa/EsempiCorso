package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{

    //costruttore con super
    public Rettangolo(int base, int altezza){
        super(base, altezza);
    }

    public int calcolaArea(int base, int altezza) {
        return (base*altezza)/2;
    }

    @Override
    public String toString(){
        return String.format("%sRettangolo e' uguale a %d.", super.toString(), calcolaArea(base, altezza));
    }
}
