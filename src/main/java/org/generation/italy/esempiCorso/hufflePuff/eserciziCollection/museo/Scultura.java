package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.museo;

public class Scultura extends OperaDArte {
    private int altezza, larghezza, profondita;

    public Scultura(String titolo, String artista, int altezza, int larghezza, int profondita) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita = profondita;
    }

    @Override
    public int printingombro() {
        return altezza * larghezza * profondita;
    }

    @Override
    public boolean confronta(OperaDArte o) {
        return this.printingombro() == o.printingombro();
    }

    @Override
    public String toString() {
        return String.format("Titolo: %s%nArtista:%s%nIngombro: %d%n", titolo, artista, printingombro());
    }
}
