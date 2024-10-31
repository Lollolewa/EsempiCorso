package org.generation.italy.interfacce;

abstract class OperaDarte {
    String nome, autore;
    int anno;
    double costo;

    public OperaDarte(String nome, String autore, int anno, double costo) {
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
        this.costo = costo;
    }
}
/*classe astratta operaDarte con proprieta nome anno autore costo*/
