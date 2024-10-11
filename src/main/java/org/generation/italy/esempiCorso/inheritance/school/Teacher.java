package org.generation.italy.esempiCorso.inheritance.school;
//ereditarietà e' il rapporto piu' stretto tra classi (is_a è la domanda per capire se ha senso l'ereditarieta')
public class Teacher extends Employee {
    //teacher è una sottoclasse/sottotipo di person (supertipo/superclasse)
    //la sottoclasse eredita le proprietà e i metodi della superclasse ma non accede direttamente alle variabili private
    //keyword che mantiene la variabile privata ma la rende visibile alle sottoclassi
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthSalary, int nMonths) {
        //this non funziona, si utilizza un altra keyword -> super(una superclasse per ogni classe)
        super(name, surname, age, monthSalary, nMonths); //richiami il costruttore della superclasse, ho creato una person
        this.subject = subject;
        this.yearOfService = yearOfService;
    }


    @Override //riprende il metodo della superclasse e lo sovrascrive, non necessario
    //non commento ma @ per obbligare il compilatore a verificare se esiste realmente la funzione nella superclasse
    //in altri linguaggi la keyword override si scrive nel metodo dopo public
    public int getAnnualSalary(){
        return yearOfService > 10 ? super.getAnnualSalary() + 500 : super.getAnnualSalary();
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "Insegno " + subject + " da " + yearOfService + " anni.";
    }

    @Override
    public void doWork(int hours) {
        System.out.println("Spiego java per " + hours + " ore");
    }

}
