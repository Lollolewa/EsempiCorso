package org.generation.italy.magicHat;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private String surname;
    private String preference;
    private String casata;
    ArrayList<Student>  students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Student(String name, String surname, String preference, String casata) {
        this.name = name;
        this.surname = surname;
        this.preference = preference;
        this.casata = casata;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPreference() {
        return preference;
    }

    public String getCasata() {
        return casata;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public void aggiungiStudente(){
        System.out.println("Inserisci nome: ");
        name = sc.nextLine();
        System.out.println("Inserisci cognome: ");
        surname = sc.nextLine();
        System.out.println("Inserisci preferenze: ");
        preference =  sc.nextLine().toUpperCase();
        students.add(new Student(name,surname,preference, null));
    }
}
