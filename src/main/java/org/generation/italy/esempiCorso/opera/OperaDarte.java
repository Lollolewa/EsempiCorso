package org.generation.italy.esempiCorso.opera;

public abstract class OperaDarte {
    public String titolo;
    public String artista;

    public OperaDarte(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract double printIngombro();

    public boolean confronta(OperaDarte o) {
        if (this.printIngombro() == o.printIngombro()) {
            return true;
        }
        return false;
    }

}

