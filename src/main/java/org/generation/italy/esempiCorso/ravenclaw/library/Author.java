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

    public List<String> getAuthorLanguages(){
        return authorLanguages;
    }

    @Override
    public String toString() {
        return String.format(
                        "ID: %d, " +
                        "Name: %s, " +
                        "Surname: %s, " +
                        "Nationality: %s, " +
                        "Birth Date: %s, " +
                        "Languages: %s",
                         authorId, name, surname, nationality, birthDate, authorLanguages
        );
    }
}
