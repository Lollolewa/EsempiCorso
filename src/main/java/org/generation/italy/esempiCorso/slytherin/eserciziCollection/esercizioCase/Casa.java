package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCase;

abstract class Casa {
    protected double superficie;
    protected int numeroStanze;

    public Casa(double superficie, int numeroStanze) {
        this.superficie = superficie;
        this.numeroStanze = numeroStanze;
    }

    // Metodo astratto costoCasa
    public abstract double costoCasa();
}