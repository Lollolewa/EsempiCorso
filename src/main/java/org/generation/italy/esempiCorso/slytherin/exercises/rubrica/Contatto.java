package org.generation.italy.esempiCorso.slytherin.exercises.rubrica;

public class Contatto {
    private String nome, cognome, numeroTelefono;

    public Contatto(String nome, String cognome, String numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s%nCognome: %s%nNumero di telefono: %s%n", nome, cognome, numeroTelefono);
    }
}
