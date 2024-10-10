package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    //le classi servono per creare oggetti e altre classi
    protected String name, surname;
    protected int age;
    //protected e la keyword per far accedere le sottoclassi alla variabile
//ha anche visibilità di package
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}