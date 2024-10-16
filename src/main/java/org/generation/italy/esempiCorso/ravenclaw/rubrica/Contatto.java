package org.generation.italy.esempiCorso.ravenclaw.rubrica;

public class Contatto {

    private String nome, cognome, nTelefono;

    public Contatto(String nome, String cognome, String nTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.nTelefono = nTelefono;
    }

    //GETTER & SETTERS
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

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public String toString(){
        return String.format("Nome: %s %nCognome: %s %nTelefono: %s%n",nome,cognome,nTelefono);
    }
}
