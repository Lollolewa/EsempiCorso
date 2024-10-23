package org.generation.italy.esempiCorso.inheritance.school;

import org.generation.italy.esempiCorso.inheritance.school.Person;
import org.generation.italy.esempiCorso.inheritance.school.Personnel;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Michael", "Johnson", 35, "Math", 11, 2500, 14);
        Personnel bidello = new Personnel("Bobby", "Rocket", 67, 1500, 14, 200, "Bidello");

        System.out.println(teacher.toString());
        System.out.println("\n");
        System.out.println(bidello.toString());
        Person x = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);

        System.out.println("\n\n");

        String[] arrayDiRocket = {"\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80"};
        System.out.println(Arrays.toString(arrayDiRocket));
    }
}