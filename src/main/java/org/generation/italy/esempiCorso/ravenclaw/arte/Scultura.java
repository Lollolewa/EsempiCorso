package org.generation.italy.esempiCorso.ravenclaw.arte;

public class Scultura extends OperaDArte{

    private double altezza, larghezza, profondita;


    public Scultura(String titolo, String artista, double altezza, double larghezza, double profondita) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = profondita;
    }


    @Override
    public double printIngombro() {
        return altezza*larghezza*profondita;
    }
}
