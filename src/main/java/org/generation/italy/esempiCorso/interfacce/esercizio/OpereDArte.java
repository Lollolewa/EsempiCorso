package org.generation.italy.esempiCorso.interfacce.esercizio;

public abstract class OpereDArte {
    protected String nome, autore;
    protected int anno;
    protected double costo;
    public OpereDArte(String nome, String autore, int anno, double costo) {
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
        this.costo = costo;
    }
    public String getNome() {
        return nome;
    }

    public int getAnno() {
        return anno;
    }

    public String getAutore() {
        return autore;
    }

    public double getCosto() {
        return costo;
    }
}
