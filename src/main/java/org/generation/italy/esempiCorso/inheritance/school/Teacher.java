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
        if(yearOfService>10){
            return monthlySalary*nMonth+500;
        } else {
            return monthlySalary*nMonth;
        }
    }
    @Override //riprende il metodo della superclasse e lo sovrascrive
    public String toString(){
        return super.toString()+ " Insegno "+subject+" da "+yearOfService+" anni"+" \nStipendio: $"+getAnnualSalary();
    }
    public void teach(){

    }
    @Override
    public void eat(){
        System.out.println("Magno un panino de corsa perché i miei studenti mi aspettano");
    }
    @Override
    public void doWork(int hours){
        System.out.println("Spiego Java");
    }
}