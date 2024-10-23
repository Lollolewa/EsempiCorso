package org.generation.italy.esempiCorso.ravenclaw.arte;

public class Quadro extends OperaDArte{

    private double altezza, larghezza;

    public Quadro(String titolo, String artista, double altezza, double larghezza) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    @Override
    public double printIngombro() {
        return altezza*larghezza;
    }
}
