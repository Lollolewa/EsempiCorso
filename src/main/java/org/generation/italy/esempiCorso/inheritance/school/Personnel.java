package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee {
    protected String role;
    protected double bonus;

    public Personnel (String name, String surname, int age, double monthlySalary, int nMonths, String role, double bonus) {
        super(name, surname, age, monthlySalary, nMonths);
        this.role = role;
        this.bonus = bonus;
    }
    @Override
    public double getAnnualSalary () {
        return super.getAnnualSalary() + bonus;
    }
    @Override
    public String toString() {
        return super.toString() + " e prendo " + getAnnualSalary() + " euro annuali, di cui bonus: " + bonus;
    }
}
