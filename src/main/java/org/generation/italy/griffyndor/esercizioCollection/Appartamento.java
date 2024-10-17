package org.generation.italy.griffyndor.esercizioCollection;

public class Appartamento extends Casa{
    private int codiceEnergetico;

    public Appartamento(int superficie, int nStanze, int codiceEnergetico) {
        super(superficie, nStanze);
        this.codiceEnergetico = codiceEnergetico;
    }


    @Override
    public double costoCasa() {
        return (superficie*1000)+ (nStanze*codiceEnergetico);
    }
}
