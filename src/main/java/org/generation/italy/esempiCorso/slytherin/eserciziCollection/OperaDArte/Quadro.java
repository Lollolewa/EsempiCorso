package org.generation.italy.esempiCorso.slytherin.eserciziCollection.OperaDArte;

public class Quadro extends OperaDArte {
    int altezza;
    int larghezza;

    public Quadro(String titolo, String artista, int altezza, int larghezza) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    @Override
    public double printingombro() {
        return this.altezza*this.larghezza;
    }
}
