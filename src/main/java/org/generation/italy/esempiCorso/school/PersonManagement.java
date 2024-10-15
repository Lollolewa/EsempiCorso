package org.generation.italy.esempiCorso.school;



public class PersonManagement {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Alessia", "Pallavera", 25, 1500, 13, "Inglese", 11);
        Personnel p1 = new Personnel("Giuseppe", "Barchetta", 25, 1800, 14, "amministrazione", 400);
        Person pers1 = new Person("Chiara", "Donghi", 25);
        Employee e1 = new Employee("Mario", "Rossi", 47, 1900, 14);

        System.out.println(t1.toString());
        System.out.println(p1.toString());
        System.out.println(pers1.toString());
        System.out.println(e1.toString());
    }
}
