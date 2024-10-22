package org.generation.italy.esempiCorso.ravenclaw.casa;

public class Appartamento extends Casa{
    private int codiceEnergetico;
    public Appartamento(int superfice, int nStanze, int codiceEnergetico){
        super(superfice, nStanze);
        this.codiceEnergetico = codiceEnergetico;
    }
    @Override
    public int costoCasa(){
        return superfice*1500 + nStanze*codiceEnergetico;
    }
}