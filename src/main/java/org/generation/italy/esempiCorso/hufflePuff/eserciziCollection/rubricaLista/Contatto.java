package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.rubricaLista;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contatto contatto = (Contatto) o;
        return nome.equals(contatto.nome) && cognome.equals(contatto.cognome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() * 7 + cognome.hashCode();
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
