package org.generation.italy.esempiCorso.inheritance.hufflePuff.eserciziCollection;

public class Casa {
    protected double superficie;
    protected int numeroStanze;

    public Casa(double superficie, int numeroStanze) {
        this.superficie = superficie;
        this.numeroStanze = numeroStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public abstract double costoCasa();
}
