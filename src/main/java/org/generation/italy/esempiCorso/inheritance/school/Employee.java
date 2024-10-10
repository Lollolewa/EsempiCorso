package org.generation.italy.esempiCorso.inheritance.school;

public abstract class Employee extends Person {

    protected int monthlySalary, nMonth;

    public Employee(String name, String surname, int age, int monthlySalary, int nMonth) {
        super(name, surname, age);
        this.monthlySalary = monthlySalary;
        this.nMonth = nMonth;
    }
    public int getAnnualSalary(){
        return monthlySalary*nMonth;
    }
    public abstract void doWork(int hours);//metodo generale polimorfico astratto
}