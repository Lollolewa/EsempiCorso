package org.generation.italy.esempiCorso.inheritance.school;


public class Teacher extends Employee{

    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthltySalary, int nMonth){
        super(name,surname,age,monthltySalary,nMonth);
        this.subject = subject;
        this.yearOfService = yearOfService;
    }
    @Override
    public int getAnnualSalary(){
        if(yearOfService>10){
            return monthlySalary*nMonth+500;
        } else {
            return monthlySalary*nMonth;
        }
    }
    @Override //riprende il metodo della superclasse e lo sovrascrive
    public String toString(){
        return super.toString()+ " Insegno "+subject+" da "+yearOfService+" anni"+" \nStipendio: $"+getAnnualSalary();
    }
    public void teach(){

    }
    @Override
    public void eat(){
        System.out.println("Magno un panino de corsa perché i miei studenti mi aspettano");
    }
    @Override
    public void doWork(int hours){
        System.out.println("Spiego Java");
    }
}

//ereditarietà e' il rapporto piu' stretto tra classi (is_a è la domanda per capire se ha senso l'ereditarieta')
public class Teacher extends Person{
    //teacher è una sottoclasse/sottotipo di person (supertipo/superclasse)
    //la sottoclasse eredita le proprietà e i metodi della superclasse ma non accede direttamente alle variabili private
    //keyword che mantiene la variabile privata ma la rende visibile alle sottoclassi
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService){
        //this non funziona, si utilizza un altra keyword -> super(una superclasse per ogni classe)
        super(name, surname, age); //richiami il costruttore della superclasse, ho creato una person
        this.subject=subject;
        this.yearOfService=yearOfService;
    }


    @Override //riprende il metodo della superclasse e lo sovrascrive, non necessario
    //non commento ma @ per obbligare il compilatore a verificare se esiste realmente la funzione nella superclasse
    //in altri linguaggi la keyword override si scrive nel metodo dopo public
    public String toString(){
        return super.toString() + " Insegno " + subject + " da " + yearOfService + " anni.";
    }
}

