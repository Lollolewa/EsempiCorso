package org.generation.italy.esempiCorso.ravenclaw.arte;

public abstract class OperaDArte {

    String titolo, artista;

    public OperaDArte(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract double printIngombro();

    public boolean confrontaOpere(OperaDArte x){
        if(printIngombro()==x.printIngombro()){
            return true;
        }
        return false;
    }


}
