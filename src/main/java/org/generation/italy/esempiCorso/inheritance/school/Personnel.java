package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee{

    private String role;
    private int bonus;
    public Personnel(String name, String surname, int age, int monthlySalary, int nMonths, String role, int bonus) {
        super(name, surname, age, monthlySalary, nMonths);
        this.role = role;
        this.bonus = bonus;
    }

    @Override
    public int getAnnualSalary(){
        return monthlySalary*nMonths+bonus;
    }

    @Override
    public String toString(){
        return String.format("%sStipendio annuale: %d %nStipendio mensile: %d%n", super.toString(), getAnnualSalary(), monthlySalary);
    }

    @Override
    public void doWork(int hours) {
        System.out.println("Spiego java per " + hours + " ore.");
    }
}
