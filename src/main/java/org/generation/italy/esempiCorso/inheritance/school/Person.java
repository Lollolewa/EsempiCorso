package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    // le classi possono anche creare altre classi
    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String toString() {
        return String.format("Ciao sono %s %s e ho %d anni.%n", name, surname, age);
    }

}
