package org.generation.italy.esempiCorso.inheritance.school;

public class Employee extends Person{

    protected int monthlySalary;
    protected int nMonth;

    public Employee(String name, String surname, int age, int monthlySalary, int nMonth){
        super(name, surname, age);
        this.monthlySalary = monthlySalary;
        this.nMonth = nMonth;
    }

    public int getAnnualSalary(){
        return monthlySalary * nMonth;
    }

    public String toString(){
        return super.toString() + "Prendo " + monthlySalary + " al mese per " + nMonth + " mesi.";
    }

}
