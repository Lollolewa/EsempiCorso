package org.generation.italy.esempiCorso.ravenclaw.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private int authorId;
    private String name, surname, nationality;
    private LocalDate birthDate;
    private List<String> authorLanguages;

    public Author(int authorId, String name, String surname, String nationality, LocalDate birthDate, List<String> authorLanguages) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.authorLanguages = new ArrayList<>(authorLanguages);
    }

    public int getAuthorId() {
        return authorId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getAuthorLanguages() {
        return authorLanguages;
    }

    @Override
    public String toString() {
        return String.format(
                "\nAuthor: \n" +
                        "Author ID: %d\n" +
                        "Name: %s\n" +
                        "Surname: %s\n" +
                        "Nationality: %s\n" +
                        "Birth Date: %s\n" +
                        "Languages: %s\n",
                authorId, name, surname, nationality, birthDate, authorLanguages
        );
    }

}
