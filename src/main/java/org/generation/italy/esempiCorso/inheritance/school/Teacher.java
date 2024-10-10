package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Employee {
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthSalary, int nMonth) {
        super(name, surname, age, monthSalary, nMonth); // parametri classe madre
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    @Override
    public int getAnnualSalary() {
        return yearOfService > 10 ? super.getAnnualSalary() + 500 : super.getAnnualSalary();
    }



    @Override
    public String toString() {
        return String.format("%sInsegno %s da %d%n", super.toString(), subject, yearOfService);
    }
}
