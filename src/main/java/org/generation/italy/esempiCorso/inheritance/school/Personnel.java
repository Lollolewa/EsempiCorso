package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee{
    private String role;
    private int bonus;

    public Personnel(String name, String surname, int age, int monthSalary, int nMonths, String role, int bonus){
        super(name, surname, age, monthSalary, nMonths);
        this.role = role;
        this.bonus = bonus;
    }

    @Override
    public int getAnnualSalary(){
        return super.getAnnualSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Il mio ruolo è: "+ role + " e ho diritto ad un bonus di : "+ bonus;
    }
}
