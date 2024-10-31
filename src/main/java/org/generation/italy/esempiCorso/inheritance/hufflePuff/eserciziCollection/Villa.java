package org.generation.italy.esempiCorso.inheritance.hufflePuff.eserciziCollection;

public class Villa extends Casa {
    private boolean piscina;

    public Villa(double superficie, int numeroStanze, boolean piscina) {
        super(superficie, numeroStanze);
        this.piscina = piscina;
    }

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

    @Override
    public String toString() {
        return "Villa [superficie=" + superficie + ", numeroStanze=" + numeroStanze + ", piscina=" + piscina + ", costo=" + costoCasa() + "]";
    }
}
