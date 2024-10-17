package org.generation.italy.esempiCorso.inheritance.school;
public class Teacher extends Employee{
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthSalary, int nMonths){
        super(name, surname, age, monthSalary, nMonths);
        this.subject = subject;
        this.yearOfService = yearOfService;
    }


    @Override
    public String toString(){
        return super.toString() + "\n" + " Insegno " + subject + " da " + yearOfService + " anni.";
    }

    public int getAnnualSalary(){
        return yearOfService > 10 ? super.getAnnualSalary() + 500 : super.getAnnualSalary();
    }
}
