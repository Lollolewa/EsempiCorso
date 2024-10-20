package org.generation.italy.esempiCorso.slytherin.exercises.sortingHat;

public class Student {
    private String name;
    private House preference;

    public Student(String name, House preference) {
        this.name = name;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }
    public House getPreference() {
        return preference;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPreference(House preference) {
        this.preference = preference;
    }

    public String toString(){
        return "Nome: " + name + ", Preferenza: " + preference + "\n";
    }
}
