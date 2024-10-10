package org.generation.italy.esempiCorso.inheritance.geometry;

public class Forma {
    private int base;
    private int altezza;

    public Forma(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getAltezza() {
        return altezza;
    }
    public int calculateArea() {
        return 0;
    }
    public String toString() {
        return "la tua area è: ";
    }
}