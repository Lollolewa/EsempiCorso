package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    // le classi servono per creare oggetti e altre classi
    protected String name, surname;
    protected int age;

    // protected viene vista dalle classi figlie (ereditarietà), ha anche visibilità di package (ma non è public)

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String toString(){
        return String.format("Nome: %s %nCognome: %s %nEta': %d %n%n", name, surname, age);
    }
    //
}
