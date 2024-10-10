package org.generation.italy.esempiCorso.inheritance.school;

public class Employee extends Person{
    protected int monthSalary, nMonths;

    public Employee(String name, String surname, int age, int monthSalary, int nMonths){
        super(name,surname,age);
        this.monthSalary = monthSalary;
        this.nMonths = nMonths;
    }

    public int getAnnualSalary(){
        return monthSalary * nMonths;
    }
    @Override
    public String toString(){
        return super.toString() + "\n" + "Il mio guadagno mensile è di " + monthSalary + " per " + nMonths + " mensilità.";
    }

}
