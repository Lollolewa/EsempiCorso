package org.generation.italy.esempiCorso.slytherin.eserciziCollection.OperaDArte;

public abstract class OperaDArte {
    public String titolo;
    public String artista;

    public OperaDArte(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract double printingombro();

    public boolean confronta(OperaDArte o, OperaDArte b){
        if(o.printingombro() == b.printingombro()){
            return true;
        }
        return false;
    }

}
