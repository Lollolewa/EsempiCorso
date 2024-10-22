package org.generation.italy.esempiCorso.griffindor.eserciziCollection.casa;

public class Appartamento extends Casa {
    private int codiceEnergetico;

    public Appartamento(int superficie, int numStanze, int codiceEnergetico) {
        super(superficie, numStanze);
        this.codiceEnergetico = codiceEnergetico;
    }
    @Override
    public double costoCasa() {
        return (superficie * 1500) + (numStanze*codiceEnergetico) ;
    }
}
