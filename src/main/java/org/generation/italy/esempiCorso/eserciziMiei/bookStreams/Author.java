package org.generation.italy.esempiCorso.eserciziMiei.bookStreams;

import java.time.LocalDate;

public class Author {
    private int id;
    private String name, surname, nationality, language;
    private LocalDate dateOfBirth;

    public Author(int id, String name, String surname, String nationality, String language, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.language = language;
        this.dateOfBirth = dateOfBirth;
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

    public String getNationality() {
        return nationality;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("Autore:%nId: %d%nNome: %s%nCognome: %s%nNazione: %s%nLingua: %s%nData di nascita: %s%n", id, name, surname, nationality, language, dateOfBirth);
    }
}
