package org.generation.italy.esempiCorso.ravenclaw.casa;

public class Villa extends Casa{
    private boolean piscina;

    public Villa(int superfice, int nStanze, boolean piscina) {
        super(superfice, nStanze);
        this.piscina = piscina;
    }

    @Override
    public int costoCasa() {
        int costoTot = superfice*2000;
        if (piscina){
            costoTot += superfice*2000+20000;
        }
        if(nStanze>10){
            costoTot += 10000;
        }
        return costoTot;
    }
}
