package org.generation.italy.esempiCorso.griffindor.eserciziCollection.casa;

public abstract class Casa {
    protected int superficie;
    protected int numStanze;
    public Casa(int superficie, int numStanze) {
        this.superficie = superficie;
        this.numStanze = numStanze;
    }
    public abstract double costoCasa();
}
