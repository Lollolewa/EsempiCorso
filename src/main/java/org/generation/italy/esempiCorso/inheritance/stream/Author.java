package org.generation.italy.esempiCorso.inheritance.stream;

import java.time.LocalDate;

public class Author {
    private int id;
    private String name, surname, lingua, nationality;
    private LocalDate dataNascita;

    public Author(int id, String name, String surname, String lingua, String nationality, LocalDate dataNascita) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lingua = lingua;
        this.nationality = nationality;
        this.dataNascita = dataNascita;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLingua() {
        return lingua;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }
}
//Author sara' una classe con stato
//id numerico
//nome
//        cognome
//data di nascita
//nazionalita'
//lingua
