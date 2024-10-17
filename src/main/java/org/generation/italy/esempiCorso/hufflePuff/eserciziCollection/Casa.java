package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public abstract class Casa {
    protected int superficie, numeroStanze;
    public Casa(int superficie, int numeroStanze){
        this.superficie = superficie;
        this.numeroStanze = numeroStanze;
    }
    public abstract int costoCasa();
}
