package org.generation.italy.esempiCorso.rubrica;

public class Contatto {

    private final String nome, cognome, telefono;

    public Contatto(String nome, String cognome, String telefono){

        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toString(){
        return "Nome " + nome + "Cognome: " + cognome + " Numero di telefono: " + telefono;
    }
}
