package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Person{

    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService){
        super(name,surname,age);
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    @Override //riprende il metodo della superclasse e lo sovrascrive
    public String toString(){
        return super.toString()+ " Insegno "+subject+" da "+yearOfService+" anni";
    }

}
