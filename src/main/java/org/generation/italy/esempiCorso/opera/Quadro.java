package org.generation.italy.esempiCorso.opera;

public class Quadro extends OperaDarte{
     double altezza;
    double larghezza;

    public Quadro(String titolo, String artista,double altezza,double larghezza) {
        super(titolo, artista);
        this.altezza=altezza;
        this.larghezza=larghezza;
    }

    @Override
    public double printIngombro() {
        return altezza*larghezza;
    }
}
