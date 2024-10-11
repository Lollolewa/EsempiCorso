package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(50, 25);
        System.out.println("Area del rettangolo: " + rettangolo.calcolaArea());

        Triangolo triangolo = new Triangolo(50, 25);
        System.out.println("Area del triangolo: " + triangolo.calcolaArea());
    }
}
