package org.generation.italy.esempiCorso.inheritance.school;


public abstract class Person {


//le classi servono per creare oggetti e altre classi
public class Person {

    //protected è la keyword per far accedere le sottoclassi alla variabile
    //ha anche visibilità di package

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

        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    public String toString(){
        return "ciao sono " + name + " " + surname + " ed ho " + age + " anni.";
    }
    //insegnanti, studenti, amministrazione sono persone che hanno proprietà diverse
    //posso creare nuove classi a partire da una classe base (in questo caso Person)

}

