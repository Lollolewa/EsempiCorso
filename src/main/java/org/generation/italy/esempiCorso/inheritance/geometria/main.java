package org.generation.italy.esempiCorso.inheritance.geometria;

public class main {
    public static void main(String[] args) {

        Triangolo triangle = new Triangolo(3,2);
        Rettangolo rectangle = new Rettangolo(2, 10);

        System.out.println(triangle.calcolaArea());
        System.out.println(rectangle.calcolaArea());

    }
}
