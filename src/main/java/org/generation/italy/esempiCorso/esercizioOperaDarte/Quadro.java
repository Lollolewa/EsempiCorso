package org.generation.italy.esempiCorso.esercizioOperaDarte;

public class Quadro extends OperaDArte{

    protected double altezza, larghezza;

    public Quadro(String titolo, String artista, double altezza, double larghezza){

        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    @Override
    public double ingombro() {
        return altezza * larghezza;
    }

    @Override
    public String toString(){
        return super.toString() + "Ingombro: " + ingombro();
    }
}
