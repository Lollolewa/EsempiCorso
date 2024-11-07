package org.generation.italy.esempiCorso.inheritance.rubrica;

public class Contatto {
    private String nome,cognome, numeroTelefonico;

    public Contatto(String nome, String cognome, String numeroTelefonico) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefonico = numeroTelefonico;
    }


    public String toString(){
        return "Nome contatto: " + nome + "\nCognome: " + cognome + "\nNumero di telefono " + numeroTelefonico;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
    return cognome;
    }
    public String getNumeroTelefonico(){
    return numeroTelefonico;
    }
}

