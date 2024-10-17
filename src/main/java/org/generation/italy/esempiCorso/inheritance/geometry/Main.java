package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {
        Triangolo triangolo = new Triangolo(10, 20);
        System.out.println("L'area del triangolo è " + triangolo.calcolaArea());
        Rettangolo rettangolo = new Rettangolo(15, 25);
        System.out.println("L'area del rettangolo è " + rettangolo.calcolaArea());
    }
}
