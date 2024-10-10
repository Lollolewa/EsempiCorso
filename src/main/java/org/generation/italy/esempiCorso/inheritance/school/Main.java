package org.generation.italy.esempiCorso.inheritance.school;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Eleonora", "Siciliano", 22, 2500, 12, "Informatica",7);
        Personnel personnel = new Personnel("Amio", "Gvng", 22, 3500, 5, "Arte", 420);

        System.out.println(teacher);
        System.out.println(personnel);
    }
}
