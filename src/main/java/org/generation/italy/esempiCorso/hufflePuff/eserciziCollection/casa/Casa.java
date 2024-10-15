package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.casa;

public abstract class Casa {
    protected int superficie, stanze;

    public Casa(int superficie, int stanze) {
        this.superficie = superficie;
        this.stanze = stanze;
    }

    public abstract int costoCasa();
}