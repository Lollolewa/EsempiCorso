package org.generation.italy.esempiCorso.inheritance.school;

public class Stagista extends Employee{

    public Stagista(String name, String surname, int age, int monthlySalary, int nMonths){
        super(name, surname, age, monthlySalary, nMonths);

    }

    @Override
    public void doWork(int hours){
        throw new RuntimeException();
    }


}
