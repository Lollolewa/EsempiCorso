package org.generation.italy.esempiCorso.inheritance.school;

public class Employee extends Person{
    protected int monthSalary, nMonths;

    public Employee(String name, String surname, int age, int monthSalary, int nMonth) {
        super(name, surname, age);
        this.monthSalary = monthSalary;
        this.nMonths = nMonth;
    }

    public int getAnnualSalary() {
        return monthSalary * nMonths;
    }
    @Override
    public String toString() {
        return String.format("%sGuadagno mensile e' di %d per %d mensilita'%n", super.toString(), monthSalary, nMonths);

    }
}
