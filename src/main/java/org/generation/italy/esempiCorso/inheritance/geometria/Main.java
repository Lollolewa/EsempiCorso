package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {

        Rettangolo rettangolo = new Rettangolo(5,6);
        Triangolo triangolo = new Triangolo(10,2);

        System.out.println(rettangolo.calcolaArea());
        System.out.println(triangolo.calcolaArea());
    }
}
