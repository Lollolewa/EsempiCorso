package org.generation.italy.esempiCorso.school;

public class Personnel extends Employee {

    protected String role;
    protected int bonus;

    public Personnel(String name, String surname, int age, int monthlySalary, int nMonths, String role, int bonus){

        super(name, surname, age, monthlySalary, nMonths);
        this.role = role;
        this.bonus = bonus;
    }

    @Override
    public int getAnnualSalary(){
        return super.getAnnualSalary() + bonus;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Ruolo " + role + "\n" +
                "Bonus " + bonus;
    }
}
