package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.museo;

public class Quadro extends OperaDArte{
    private int altezza, larghezza;

    public Quadro(String titolo, String artista, int altezza, int larghezza) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
    }


    @Override
    public int printingombro() {
        return altezza * larghezza;
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
