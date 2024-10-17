package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public class Appartamento extends Casa {
    protected int codiceEnergetico;
    public Appartamento(int codiceEnergetico, int numeroStanze, int superficie){
        super(superficie,numeroStanze);
        this.codiceEnergetico = codiceEnergetico;
    }

    // costoCasa = superficie * 1500+ numero delle stanze * codice energetico.


    @Override
    public int costoCasa() {
        return superficie * 1500 + numeroStanze * codiceEnergetico;
    }
    public int getCodiceEnergetico() {
        return codiceEnergetico;
    }

}
