package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public class Villa extends Casa{
    boolean piscina;
    public Villa(boolean piscina,int superficie, int numeroStanze){
        super(superficie,numeroStanze);
        this.piscina = piscina;
    }

    @Override
    public int costoCasa() {
        int costoBase = superficie * 2000;
        if(piscina){
            costoBase += 20000;
        }
        if(numeroStanze>10){
            costoBase += 10000;
        }
        return costoBase;
    }
    public boolean hasPiscina() {
        return piscina;
    }
}
