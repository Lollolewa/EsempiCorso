package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.museo;

public abstract class OperaDArte {
    protected String titolo, artista;

    public OperaDArte(String titolo, String artista){
        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract int printingombro();
    public abstract boolean confronta(OperaDArte o);
}
