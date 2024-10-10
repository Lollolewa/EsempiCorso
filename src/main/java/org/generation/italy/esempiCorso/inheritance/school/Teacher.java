package org.generation.italy.esempiCorso.inheritance.school;

//ereditarietà è il rapporto più stretto tra le classi, cambiando qualcosa nella madre, lo cambi anche nelle figlie e nelle loro figlie e nelle loro figlie

public class Teacher extends Person{
    //teacher è una sottoclasse/sottotipo di person ( supertipo/superclasse);
    //la sottoclasse eredita le proprietà e i metodi della superclasse;
    //le variabili restano PRIVATE, perciò non sono direttamente raggiungibili
    //Di conseguenza la sottoclasse eredita il metodo, può usarlo, ma non accede direttamente alla variabile;

    //esiste una keyword che mantiene le variabili private ma le rende visibili alle sottoclassi
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService) {
        //this non funziona, si utilizza un'altra keyword -> super (una superclasse per ogni classe)
        super(name, surname, age); //richiami il costruttore della superclasse, ho creato così una person.
        this.subject = subject;
        this.yearOfService = yearOfService;
    }


    @Override //riprende il metodo della superclasse e lo sovrascrive. Ci aiuta anche nel caso in cui sbagliassimo a scrivere il nome del metodo
    public String toString() {
        return super.toString() + " Insegno " + subject + " da " + yearOfService + " anni.";
    }
}
