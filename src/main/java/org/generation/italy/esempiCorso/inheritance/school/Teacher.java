package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Person{
    private String subject;
    private int yos;

    public Teacher(String name, String surname, int age, String subject, int yos) {
        super(name, surname, age);
        this.subject = subject;
        this.yos = yos;
    }
    @Override
    public String toString() {
        return super.toString() + " Ed insegno " + subject + " da " + yos + " anni!";
    }
}
