package org.generation.italy.esempiCorso.inheritance.school;

public class Person {

    protected String name, surname;
    protected int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    @Override
    public String toString(){
        return String.format("Ciao sono %s %s e ho %d anni", name,surname,age);
    }
    public void eat(){
        System.out.println("Me magno 'na carbonara");
    }
    public void chat(){
        System.out.println("Faccio due chiacchiere.");
    }
}
