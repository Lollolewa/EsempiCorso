package org.generation.italy.esempiCorso.inheritance.school;
// l'ereditarietà è il rapporto piu stretto possibile tra le classi, quindi un problema alla classe madre potrebbe
// dare problemi anche alle classi figlie e nipoti, crendo un effetto domino di problemi tra classi

// quindi è un'arma a doppio taglio perchè se abusato troppo, con modifiche future alla classe madre, toccherebbe
// modificare tutte le sottoclassi multiple

public class Teacher extends Employee{
    // extends Person indica che sia un sottotipo o sottoclasse di Person
    // la sottoclasse eredita tutte le proprietà e i metodi della classe
    // i metodi restano privati se erano privati, quindi la classe figlia eredita le variabili ma non direttamente
    // accessibili (se private), quindi in quel caso eredita il getVaribile

    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthlySalary, int nMonths){
        super(name, surname, age, monthlySalary, nMonths); // con super richiami il costruttore di Person, creo una persona
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    @Override
    public int getAnnualSalary(){
        return yearOfService>10 ? super.getAnnualSalary()+500 : super.getAnnualSalary();
    }

    @Override // override riprende il metodo della classe padre (il metodo del padre deve vere lo stesso nome
     // della classe padre, quindi lo sovrascrive)
    // la @ di override serve per obbligare il compilatore a verificare se esista veramente un metodo con lo stesso nome
    // nella superclasse
    public String toString(){
        return String.format("%sInsegno: %s da %d anni.%nStipendio annuale: %d %nStipendio mensile: %d%n", super.toString(), subject, yearOfService, getAnnualSalary(), monthlySalary);
    }

    @Override
    public void doWork(int hours){
        System.out.println("Spiego java per " + hours + " ore.");
    }
}
