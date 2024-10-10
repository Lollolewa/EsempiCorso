package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    //le classi servono per creare oggetti e altre classi
    //protected viene usata per far ereditare alle classi figlie le sue propietà e funzioni
    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String toString(){
        return "ciao sono " + name + " " + surname + "ed ho " + age;
    }
    //insegnati, sudenti, amministrazione che hanno propietà diverse, partendo da una classe base possiamo creare varie altre
}
