package org.generation.italy.esempiCorso.lambdaStreams;

import java.time.LocalDate;

public class Author {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String nazionalita;
    private String lingua;

    public Author(int id, String nome, String cognome, LocalDate dataNascita, String nazionalita, String lingua) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.nazionalita = nazionalita;
        this.lingua = lingua;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return String.format("Author\n" +
                "   ID: %d \n" +
                "   Nome: '%s' \n" +
                "   Cognome: '%s' \n" +
                "   Data di Nascita: %s \n" +
                "   Nazionalità: '%s' \n" +
                "   Lingua: '%s' \n",
                id, nome, cognome, dataNascita, nazionalita, lingua);
    }
}