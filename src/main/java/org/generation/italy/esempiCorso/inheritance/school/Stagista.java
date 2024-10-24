package org.generation.italy.esempiCorso.inheritance.school;

public class Stagista extends Employee{
    public Stagista(String name, String surname, int age, double monthlySalary, int nMonths){
        super(name, surname, age, monthlySalary, nMonths);
    }

    @Override
    public void doWork(int hours) {
        throw new RuntimeException();
        //segnala un errore, non voglio che questo metodo venga chiamato
    }
}
