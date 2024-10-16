package org.generation.italy.esempiCorso.school;

public class Teacher extends Employee{

    protected String subject;
    protected int yearOfService;

    public Teacher(String name, String surname, int age, int monthlySalary, int nMonths, String subject, int yearOfService){

        super(name, surname, age, monthlySalary, nMonths);
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    @Override
    public int getAnnualSalary(){
        return yearOfService > 10 ? super.getAnnualSalary() + 500 : super.getAnnualSalary();
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Materia: " + subject + "\n" +
                "anni di servizio" + yearOfService;
    }
}
