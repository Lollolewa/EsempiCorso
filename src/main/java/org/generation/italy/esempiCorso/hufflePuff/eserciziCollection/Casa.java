package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public abstract class Casa {
    protected int superficie;
    protected int stanze;

    public Casa(int superficie, int stanze) {
        this.superficie = superficie;
        this.stanze = stanze;
    }

    public abstract int costoCasa();

}
