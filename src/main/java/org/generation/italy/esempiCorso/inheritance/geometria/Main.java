package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(10, 5);
        Triangolo triangolo = new Triangolo(8, 6);

        System.out.println(rettangolo.toString());
        System.out.println(triangolo.toString());
    }
}