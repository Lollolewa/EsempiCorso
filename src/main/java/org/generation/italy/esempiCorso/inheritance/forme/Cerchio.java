package org.generation.italy.esempiCorso.inheritance.forme;

class Cerchio extends Forma {
    private double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    @Override
    double calcolaArea() {
        return Math.PI * raggio * raggio;
    }

    @Override
    double calcolaPerimetro() {
        return 2 * Math.PI * raggio;
    }
}