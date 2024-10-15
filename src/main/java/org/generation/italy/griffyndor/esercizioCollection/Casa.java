package org.generation.italy.griffyndor.esercizioCollection;

public abstract class Casa {
    protected int superficie;
    protected int nStanze;

    public Casa(int superficie, int nStanze) {
        this.superficie = superficie;
        this.nStanze = nStanze;
    }

    public Casa() {

    }

    public abstract double costoCasa();
}