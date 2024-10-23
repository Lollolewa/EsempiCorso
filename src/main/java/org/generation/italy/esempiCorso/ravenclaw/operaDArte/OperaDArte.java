package org.generation.italy.esempiCorso.ravenclaw.operaDArte;

public abstract class OperaDArte {
    public String titolo, artista;

    public OperaDArte(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }
    public abstract double printIngombro();
    public abstract boolean confronto(OperaDArte o);
    
}
