package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programmer {
    private String name, surname;
    private boolean male;
    private LocalDate birthDate;
    private double salary;
    private List<String> languages;

    public Programmer(String name, String surname, boolean male, LocalDate birthDate, double salary, List<String> languages){
        this.name=name;
        this.surname=surname;
        this.male=male;
        this.birthDate=birthDate;
        this.salary=salary;
        this.languages=new ArrayList<>(languages);
    }
    public boolean isMale() {
        return male;
    }
    public boolean isFemale(){
        return !isMale();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }
    public boolean isSalaryBiggerThan(double salary){
        return this.salary>salary;
    }
    public int getAge(){
        //return LocalDate.now().getYear()-birthDate.getYear();
        return this.birthDate.until(LocalDate.now()).getYears();
    }
    public String getSurname(){
        return surname;
    }
    public int getNumLanguages(){
        return languages.size();
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
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", languages=" + languages +
                '}';
    }
}
