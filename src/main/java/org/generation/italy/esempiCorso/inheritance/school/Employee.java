package org.generation.italy.esempiCorso.inheritance.school;

public abstract class Employee extends Person{
    protected double monthlySalary;
    protected int nMonths;

    public Employee (String name, String surname, int age, double monthlySalary, int nMonths) {
        super(name,surname,age);
        this.monthlySalary = monthlySalary;
        this.nMonths = nMonths;
    }
    public double getMonthlySalary() {
        return monthlySalary;
    }
    public int getnMonths() {
        return nMonths;
    }
    public double getAnnualSalary () {
        return monthlySalary * (double)nMonths;

    }

}
