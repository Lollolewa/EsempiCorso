package org.generation.italy.esempiCorso.inheritance.geometria;

public class Forma {
    protected int base, altezza;

    public Forma(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }


    public int calcolaArea() {
        return 0;
    }
}

//rettangolo e triangolo devono fare l'override di calcolaArea;