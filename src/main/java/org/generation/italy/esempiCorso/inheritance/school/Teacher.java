package org.generation.italy.esempiCorso.inheritance.school;

public class Teacher extends Person {
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService) {
        super(name, surname, age); // parametri classe madre
        this.subject = subject;
        this.yearOfService = yearOfService;
    }

    @Override
    public String toString() {
        return
                String.format("%sInsegno %s da %d anni.", super.toString(), subject, yearOfService);
    }
}
