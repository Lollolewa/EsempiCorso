package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    //le classi servono per creare oggetti e altre classi;
    protected String name, surname;
    protected int age;
    //protected è la keyword per far accedere le sottoclassi alla variabile, e inoltre ha anche visibilità nel package.

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    //vogliamo andare a creare insegnanti, studenti, amministrazione di una scuola, che sono comunque persone ma hanno proprietà diverse
    //posso creare nuove classi a partire da una classe base (in questo caso Person);

    public String toString() {
        return "Ciao sono " + name + " " + surname + ", ho " + age + " anni.";
    }
}
