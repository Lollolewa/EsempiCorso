package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCase;

public class Villa extends Casa {
    private boolean piscina;

    public Villa(double superficie, int numeroStanze, boolean piscina) {
        super(superficie, numeroStanze);
        this.piscina = piscina;
    }

    // Implementazione del metodo costoCasa
    @Override
    public double costoCasa() {
        double costo = superficie * 2000;
        if (piscina) {
            costo += 20000;
        }
        if (numeroStanze >= 10) {
            costo += 10000;
        }
        return costo;
    }
}
