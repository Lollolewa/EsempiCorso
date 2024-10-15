package org.generation.italy.esempiCorso.inheritance.school;

<<<<<<<< HEAD:src/main/java/org/generation/italy/esempiCorso/inheritance/school/Start.java
import java.util.Arrays;

public class Start {
    public static void main(String[] args){

        Teacher teacher = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
        Personnel bidello = new Personnel("Bobby", "Rocket", 67, 1500, 14, 200, "Bidello");

        System.out.println(teacher.toString());
        System.out.println("\n");
        System.out.println(bidello.toString());

        System.out.println("\n\n");

        String[] arrayDiRocket = {"\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80,\uD83D\uDE80"};
        System.out.println(Arrays.toString(arrayDiRocket));

========
public class Start {
    public static void main(String[] args){
        System.out.println("testing github");
        System.out.println("Aggiunto da Alessia");
>>>>>>>> PietroMarinari:src/main/java/org/generation/italy/esempiCorso/inheritance/Start.java
    }
}
