package org.generation.italy.esempiCorso.gryffindor.esercizioCase;

public abstract class Casa {
    protected int superficie, numStanze;

    public Casa(int superficie, int numStanze){
        this.superficie=superficie;
        this.numStanze=numStanze;
    }
    public abstract double costoCasa();
}
