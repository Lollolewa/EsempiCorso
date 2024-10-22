package org.generation.italy.esempiCorso.eserciziStream;

import java.time.LocalDate;

public class Autore {
    private int idNumerico;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String nazionalita;
    private String lingua;

    public Autore(int idNumerico, String nome, String cognome, LocalDate dataDiNascita, String nazionalita, String lingua) {
        this.idNumerico = idNumerico;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.nazionalita = nazionalita;
        this.lingua = lingua;
    }

    public String getLingua() {
        return lingua;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdNumerico() {
        return idNumerico;
    }
}
