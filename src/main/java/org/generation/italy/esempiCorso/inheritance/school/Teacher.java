package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Employee{

    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService, int monthltySalary, int nMonth){
        super(name,surname,age,monthltySalary,nMonth);
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    @Override
    public int getAnnualSalary(){
       return yearOfService>10 ? monthlySalary*nMonth+500 : monthlySalary*nMonth;
    }

    @Override //riprende il metodo della superclasse e lo sovrascrive
    public String toString(){
        return super.toString()+ "\nInsegno "+subject+" da "+yearOfService+" anni"+" \nStipendio: $"+getAnnualSalary();
    }

}

