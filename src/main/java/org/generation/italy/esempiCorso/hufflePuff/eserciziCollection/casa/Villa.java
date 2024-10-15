package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.casa;

public class Villa extends Casa{
    private boolean piscina;

    public Villa(int superficie, int stanze, boolean piscina) {
        super(superficie, stanze);
        this.piscina = piscina;
    }

    @Override
    public int costoCasa() {
        int costoCasa = superficie * 2000;

        if (piscina) {
            costoCasa += 20000;
        }
        if (stanze >= 10) {
            costoCasa += 10000;
        }
        return costoCasa;
    }
}