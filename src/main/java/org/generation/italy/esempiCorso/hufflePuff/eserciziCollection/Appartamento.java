package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public class Appartamento extends Casa{
    private int codiceEnergetico;

    public Appartamento(int superficie,int stanze,int codiceEnergetico) {
        super(superficie,stanze);
        this.codiceEnergetico = codiceEnergetico;
    }

    @Override
    public int costoCasa() {
        return superficie*1500 + stanze * codiceEnergetico;

    }
}
