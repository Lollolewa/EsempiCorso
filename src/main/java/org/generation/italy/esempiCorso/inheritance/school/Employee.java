package org.generation.italy.esempiCorso.inheritance.school;

public class Employee extends Person{

    protected int monthlySalary, nMonths;
    public Employee(String name, String surname, int age, int monthlySalary, int nMonths) {
        super(name, surname, age);
        this.monthlySalary = monthlySalary;
        this.nMonths = nMonths;
    }

    public int getAnnualSalary(){
        return monthlySalary*nMonths;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
