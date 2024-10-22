package org.generation.italy.esempiCorso.esercizioOperaDarte;

public class Scultura extends OperaDArte{

    double altezza, larghezza, profondita;

    public Scultura(String titolo, String artista, double altezza, double larghezza, double profondita){

        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = profondita;

    }

    @Override
    public double ingombro(){
        return altezza * larghezza * profondita;
    }

    @Override
    public String toString(){
        return super.toString() + "Ingombro: " + ingombro();
    }
}
