package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee {

    private String role;
    private int bonus = 0;

    public Personnel(String name, String surname, int age, int monthlySalary, int nMonth, int bonus, String role) {
        super(name, surname, age, monthlySalary, nMonth);
        this.bonus = bonus;
        this.role = role;
    }

    @Override
    public int getAnnualSalary(){
        return monthlySalary*nMonth+bonus;
    }

    @Override
    public String toString(){
        return super.toString()+"\nRuolo: "+role+" \nStipendio: $"+getAnnualSalary();
    }

}
