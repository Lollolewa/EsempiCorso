package org.generation.italy.esempiCorso.griffindor.eserciziCollection.Libreria;

import java.time.LocalDate;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private String language;


    public Author(int id, String firstName, String lastName, LocalDate birthDate, String nationality, String language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public String getLanguage() {
        return language;
    }
}

