package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {
        Triangolo triangolo = new Triangolo(5, 10);
        Rettangolo rettangolo = new Rettangolo(4, 6);

        System.out.printf("Area del triangolo: %.2f%n ", triangolo.calcolaArea());
        System.out.printf("Area del rettangolo: %.2f%n", rettangolo.calcolaArea());
    }
}
