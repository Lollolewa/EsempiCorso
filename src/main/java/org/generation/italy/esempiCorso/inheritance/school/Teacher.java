package org.generation.italy.esempiCorso.inheritance.school;
//ereditarietà e' il rapporto piu' stretto tra classi (is_a è la domanda per capire se ha senso l'ereditarieta')
public class Teacher extends Employee{
    //teacher è una sottoclasse/sottotipo di person (supertipo/superclasse)
    //la sottoclasse eredita le proprietà e i metodi della superclasse ma non accede direttamente alle variabili private
    //keyword che mantiene la variabile privata ma la rende visibile alle sottoclassi
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, double monthlySalary, int nMonths, String subject, int yearOfService){
        //this non funziona, si utilizza un altra keyword -> super(una superclasse per ogni classe)
        super(name, surname, age, monthlySalary, nMonths); //richiami il costruttore della superclasse, ho creato una person
        this.subject=subject;
        this.yearOfService=yearOfService;
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + yearOfService >= 10 ? 500: 0;
    }

    @Override //riprende il metodo della superclasse e lo sovrascrive, non necessario
    //non commento ma @ per obbligare il compilatore a verificare se esiste realmente la funzione nella superclasse
    //in altri linguaggi la keyword override si scrive nel metodo dopo public
    public String toString(){
        return super.toString() + " Insegno " + subject + " da " + yearOfService + " anni e prendo " + getAnnualSalary() + " euro annuali, bonus compreso.";

    }
    public void teach(){

    }

    public void eat(){
        System.out.println("mangio un panino pechè i miei studenti mi aspettano");
    }

    //se una classe concreta estende una classe astratta deve overridare i suoi metodi astratti per ridefinirli e renderli concreti
    @Override
    public void doWork(int hours) {
        System.out.println("Spiego java");
    }
}
