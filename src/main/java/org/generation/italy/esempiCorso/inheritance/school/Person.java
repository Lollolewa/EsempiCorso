package org.generation.italy.esempiCorso.inheritance.school;

public class Person {
    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String toString(){
        return "Ciao sono " + name + " " + surname + ", ho " + age + " anni!";
    }
}