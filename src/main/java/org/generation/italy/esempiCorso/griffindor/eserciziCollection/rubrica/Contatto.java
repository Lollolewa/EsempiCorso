package org.generation.italy.esempiCorso.griffindor.eserciziCollection.rubrica;

public class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ": " + telefono;
    }
}
