package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programmer {
    private String name, surname;
    private boolean male;
    private LocalDate birthdate;
    private double salary;
    private List<String> languages;

    public Programmer(String name, String surname, boolean male, LocalDate birthdate, double salary, List<String> languages){
        this.name = name;
        this.surname = surname;
        this.male = male;
        this.birthdate = birthdate;
        this.salary = salary;
        this.languages = new ArrayList<>(languages);
        //this.languages = languages;
    }

    public String getSurname() {
        return surname;
    }
    public int getNumLanguages(){return languages.size();}
    public boolean isMale() {
        return male;
    }
    public boolean isFemale() {
        return !isMale();
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public double getSalary() {
        return salary;
    }
    public boolean isSalaryBiggerThan(double salary) {
        return this.salary >=salary;
    }
    public int getAge(){
        return this.birthdate.until(LocalDate.now()).getYears();
    }
    public void addLanguage(String language){
        languages.add(language);
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
