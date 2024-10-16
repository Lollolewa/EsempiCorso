package org.generation.italy.esempiCorso.inheritance.forme;

// Sottoclasse Rettangolo che estende Forma
class Rettangolo extends Forma {
    private double larghezza;
    private double altezza;

    public Rettangolo(double larghezza, double altezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    @Override
    double calcolaArea() {
        return larghezza * altezza;
    }

    @Override
    double calcolaPerimetro() {
        return 2 * (larghezza + altezza);
    }
}
