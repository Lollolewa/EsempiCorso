package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    //le classi servono per creare oggetti e altre classi
    //protected è la keyword per far accedere le sottoclassi alla variabile
    //ha anche visibilità di package ma non è public
    protected String name, surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String toString(){
        return "ciao sono " + name + " " + surname + " ed ho " + age + " anni.";
    }




}
