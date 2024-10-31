package org.generation.italy.esempiCorso.inheritance.hufflePuff.eserciziCollection;

public class Appartamento extends Casa {
    private int codiceEnergetico;

    public Appartamento(double superficie, int numeroStanze, int codiceEnergetico) {
        super(superficie, numeroStanze);
        this.codiceEnergetico = codiceEnergetico;
    }

    @Override
    public double costoCasa() {
        return superficie * 1500 + numeroStanze * codiceEnergetico;
    }

    @Override
    public String toString() {
        return "Appartamento [superficie=" + superficie + ", numeroStanze=" + numeroStanze + ", codiceEnergetico=" + codiceEnergetico + ", costo=" + costoCasa() + "]";
    }
}
