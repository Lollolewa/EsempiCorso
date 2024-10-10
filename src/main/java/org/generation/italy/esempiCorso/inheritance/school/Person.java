package org.generation.italy.esempiCorso.inheritance.school;
//le classi servono per creare oggetti e altre classi
public abstract class Person {
//classe abstract serve per non consentire di creare oggetti di questa classe

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
    public void eat(){
        System.out.println("Me magno na carbonara");
    }
    public void chat(){
        System.out.println("Faccio due chiacchiere");
    }
}
