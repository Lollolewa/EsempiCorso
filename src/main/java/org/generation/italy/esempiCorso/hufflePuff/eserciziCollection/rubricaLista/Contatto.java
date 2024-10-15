package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.rubricaLista;

public class Contatto {
    private String nome, cognome, numero;

    public Contatto(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
