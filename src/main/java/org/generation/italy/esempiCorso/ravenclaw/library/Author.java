package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name, surname, nationality;
    private int id;
    private LocalDate dateOfBirth;
    private List<String> authorLanguages;

    public Author(String name, String surname, String nationality, int id, LocalDate dateOfBirth, List<String> authorLanguages) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.authorLanguages = new ArrayList<>(authorLanguages);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public List<String> getAuthorLanguages() {
        return authorLanguages;
    }
    public void setAuthorLanguages(List<String> authorLanguages) {
        this.authorLanguages = authorLanguages;
    }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", authorLanguages=" + authorLanguages +
                '}';
    }
}
