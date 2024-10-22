package org.generation.italy.esempiCorso.ravenclaw.operaDArte;

public class Scultura extends OperaDArte {
    private int altezza, larghezza, profondità;

    public Scultura(String titolo, String artista, int altezza, int larghezza, int profondità) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
    }

    @Override
    public double printIngombro() {
        return altezza * larghezza * profondità;
    }

    @Override
    public boolean confronto(OperaDArte o) {
        if (o.printIngombro() == altezza * larghezza) {
            return true;
        } else {
            return false;
        }
    }
}