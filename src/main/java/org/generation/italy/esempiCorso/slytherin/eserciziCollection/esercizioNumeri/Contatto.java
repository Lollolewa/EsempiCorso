package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioNumeri;

public class Contatto {
    private String nome, cognome, number;

    public Contatto(String nome, String cognome, String number){
        this.nome = nome;
        this.cognome = cognome;
        this.number = number;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumber() {
        return number;
    }

    public String toString(){
        return String.format("Nome: %s%nCognome: %s%nNumero: %s", nome, cognome, number);
    }
}
