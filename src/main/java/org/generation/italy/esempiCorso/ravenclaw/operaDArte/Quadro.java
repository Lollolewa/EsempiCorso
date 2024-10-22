package org.generation.italy.esempiCorso.ravenclaw.operaDArte;

public class Quadro extends OperaDArte{
    private int altezza, larghezza;

    public Quadro(String titolo, String artista, int altezza, int larghezza) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;

    }

    @Override
    public double printIngombro() {
        return altezza*larghezza;
    }

    @Override
    public boolean confronto(OperaDArte o) {
        if(o.printIngombro() == altezza*larghezza){
            return true;
        }else{
            return false;
        }
    }
}
