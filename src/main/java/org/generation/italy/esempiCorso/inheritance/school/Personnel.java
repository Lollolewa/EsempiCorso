package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee{

    private String role;
    private int bonus;

    public Personnel(String name, String surname, int age, int monthlySalary, int nMonth, String role, int bonus) {
        super(name, surname, age, monthlySalary, nMonth);
        this.role = role;
        this.bonus = bonus;
    }

    @Override
    public int getAnnualSalary(){
        return super.getAnnualSalary() + bonus;
    }

    public String toString(){
        return super.toString() + "Sono un " + role + "e all'anno prendo " + getAnnualSalary() + " per via del bonus di " + bonus + " euro.";
    }
}
