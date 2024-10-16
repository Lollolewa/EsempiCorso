package org.generation.italy.esempiCorso.inheritance.school;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Michael", "Johnson", 35, "Math", 11, 2500, 14);
        Personnel bidello = new Personnel("Bobby", "Rocket", 67, 1500, 14, "Bidello", 200);

        System.out.println(teacher.toString());
        System.out.println("\n");
        System.out.println(bidello.toString());

        System.out.println("\n\n");

        String[] arrayDiRocket = {"\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80"};
        System.out.println(Arrays.toString(arrayDiRocket));
    }
}