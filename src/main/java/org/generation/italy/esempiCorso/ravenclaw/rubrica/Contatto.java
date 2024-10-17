package org.generation.italy.esempiCorso.ravenclaw.rubrica;

public class Contatto {
    protected String nome, cognome, numTelefono;

    public Contatto(String nome, String cognome, String numTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTelefono = numTelefono;
    }
    public String toString(){
        return "Il nome e' " + nome + " cognome " + "\n Il num di tel e' " + numTelefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumTelefono() {
        return numTelefono;
    }
}
