package org.generation.italy.esempiCorso.inheritance.school;
//le classi servono per creare oggetti e altre classi
public abstract class Person {

    //protected è la keyword per far accedere le sottoclassi alla variabile
    //ha anche visibilità di package
    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    public String toString(){
        return "ciao sono " + name + " " + surname + " ed ho " + age + " anni.";
    }
}
