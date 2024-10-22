package org.generation.italy.esempiCorso.esercizioOperaDarte;

public abstract class OperaDArte {

    protected String titolo, artista;

    public OperaDArte(String titolo, String artista){

        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract double ingombro();

    public boolean confronto(OperaDArte o){
        return false; // TODO: verifica se due opere d'arte hanno lo stesso ingombro
    }

    public String toString(){
        return "Titolo: " + titolo + " " + "Artista: " + artista;
    }
}
