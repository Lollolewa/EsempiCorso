package org.generation.italy.esempiCorso.inheritance.school;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Mariardo", "Colla", 27, "Dormire", 25, 600, 12);
        Personnel p1 = new Personnel("Giuseppe", "Bokka", 40, 1500, 13, "Scultore", 2000);

        System.out.println(t1.toString());
        System.out.println(p1.toString());
    }
}
