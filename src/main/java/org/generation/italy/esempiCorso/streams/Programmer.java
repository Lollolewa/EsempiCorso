package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.List;

public class Programmer {
    private String name, surname;
    private boolean male;
    private LocalDate birthdate;
    private double salary;
    private List<String> languages;

    public Programmer(String name, String surname, boolean male, LocalDate birthdate, double salary, List<String> languages) {
        this.name = name;
        this.surname = surname;
        this.male = male;
        this.birthdate = birthdate;
        this.salary = salary;
        this.languages = languages;
    }

    public boolean isMale() {
        return male;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", male=" + male +
                ", birthdate=" + birthdate +
                ", salary=" + salary +
                ", languages=" + languages +
                '}';
    }
}
