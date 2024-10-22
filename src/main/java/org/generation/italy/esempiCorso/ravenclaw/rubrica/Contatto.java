package org.generation.italy.esempiCorso.ravenclaw.rubrica;

import javax.xml.namespace.QName;

public class Contatto {
    protected  String nome, cognome, numeroTelefono;

    public Contatto(String nome, String cognome, String numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + numeroTelefono;
    }
}

