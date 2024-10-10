package org.generation.italy.esempiCorso.inheritance.school;
//ereditarietà I |il rapporto piu' stretto tra classi (is_a)
public class Teacher extends Person {
    //teacher è una sottoclasse/sottotipo di person (supertipo/superclasse)
//la sottoclasse eredita le proprietà e i metodi della superclasse
    //le variabili restano private, non sono direttamente raggiungibili
//la sottoclasse eredita il metodo ma non accede alla variabile
    //keyword che mantiene la variabile privata ma la rende visibile alle sottoclassi è protected
    //la sottoclasse eredita le proprietà e i metodi della superclasse ma non accede direttamente alle variabili private

    private String subject;
    private int  yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService) {
        //this non funziona, si utilizza un altra keyword -> super(una superclasse per ogni classe)
        super(name,surname, age);
        //richiami il costruttore della superclasse (della classe madre) , ho creato una person
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
