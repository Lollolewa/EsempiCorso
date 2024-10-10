package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Employee{
    protected String subject;
    protected int yearOfService;

    public Teacher(String name, String surname, int age, double monthlySalary, int nMonths, String subject, int yearOfService){
        super(name, surname, age, monthlySalary, nMonths);
        this.subject=subject;
        this.yearOfService=yearOfService;
    }
    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + yearOfService >= 10 ? 500: 0;
    }
    @Override
    public String toString() {
        return super.toString() + " e prendo " + getAnnualSalary() + " euro annuali, bonus compreso.";
    }
}
