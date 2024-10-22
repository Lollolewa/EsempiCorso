package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String name,surname;
    boolean male;
    LocalDate birthdate;
    double salary;
    List<String> lenguages;

    public Programmer(String name, String surname, boolean male, LocalDate birthdate, double salary, List<String> lenguages) {
        this.name = name;
        this.surname = surname;
        this.male = male;
        this.birthdate = birthdate;
        this.salary = salary;
        this.lenguages = new ArrayList<>();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isMale() {
        return male;
    }
    public boolean isFemale(){

     return !isMale();
    }
    public boolean isSalaryBiggerThan(double salary){
    return 
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", male=" + male +
                ", birthdate=" + birthdate +
                ", salary=" + salary +
                ", lenguages=" + lenguages +
                '}';
    }
}
