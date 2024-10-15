package org.generation.italy.esempiCorso.inheritance.geometria;

public abstract class Forma {
    protected int base, altezza;

    public Forma(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }


    public abstract int calcolaArea();
}

//rettangolo e triangolo devono fare l'override di calcolaArea;