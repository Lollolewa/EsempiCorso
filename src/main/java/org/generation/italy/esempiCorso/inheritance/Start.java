package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Person;
import org.generation.italy.esempiCorso.inheritance.school.Personnel;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){

        Teacher teacher = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
        Personnel bidello = new Personnel("Bobby", "Rocket", 67, 1500, 14, 200, "Bidello");

        System.out.println(teacher.toString());
        System.out.println("\n");
        System.out.println(bidello.toString());
        Person x = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);

    }

}
