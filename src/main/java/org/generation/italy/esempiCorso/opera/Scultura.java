package org.generation.italy.esempiCorso.opera;

public class Scultura extends OperaDarte{
     int altezza;
     int larghezza;
     int profondita;

    public Scultura(String titolo,String artista,int altezza,int larghezza,int profondita){
        super(titolo,artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondita=profondita;
    }
    @Override
    public double printIngombro() {
        return altezza*larghezza*profondita;
    }
}
