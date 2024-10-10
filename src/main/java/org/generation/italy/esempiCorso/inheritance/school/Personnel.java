package org.generation.italy.esempiCorso.inheritance.school;

public class Personnel extends Employee {
    private String role;
    private int bonus;

    public Personnel(String name, String surname, int age, int monthSalary, int nMonth, String role, int bonus) {
        super(name, surname, age, monthSalary, nMonth);
        this.role = role;
        this.bonus = bonus;
    }

    @Override
    public int getAnnualSalary() {
        return super.getAnnualSalary() + bonus;
    }

    @Override
    public String toString() {
        return String.format("%sIl mio ruolo è %s e ho diritto a un bonus di %d euro.%n", super.toString(), role, bonus);
    }
}
