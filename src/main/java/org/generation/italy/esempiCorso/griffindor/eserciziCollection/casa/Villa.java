package org.generation.italy.esempiCorso.griffindor.eserciziCollection.casa;

public class Villa extends Casa {
    private boolean piscina;
    public Villa(int superficie, int numStanze, boolean piscina) {
        super(superficie, numStanze);
        this.piscina = piscina;
    }

    @Override
    public double costoCasa() {
        double costoCasa = superficie * 2000;
        if(piscina) {
            costoCasa +=  20000;
        }
        if(numStanze >= 10) {
            costoCasa += 10000;
        }
        return costoCasa;
    }
}
