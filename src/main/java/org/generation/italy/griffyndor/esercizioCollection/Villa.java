package org.generation.italy.griffyndor.esercizioCollection;

public class Villa extends Casa{
    private boolean piscina;

    public Villa(int superficie, int nStanze, boolean piscina) {
        super(superficie,nStanze);
        this.piscina = piscina;
    }


    @Override
    public double costoCasa() {
        return 0;
    }
}
