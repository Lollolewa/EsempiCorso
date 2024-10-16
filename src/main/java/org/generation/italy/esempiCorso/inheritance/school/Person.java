package org.generation.italy.esempiCorso.inheritance.school;

public abstract class Person {

    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Ciao sono %s %s e ho %d anni.",name,surname,age);
    }

}
//