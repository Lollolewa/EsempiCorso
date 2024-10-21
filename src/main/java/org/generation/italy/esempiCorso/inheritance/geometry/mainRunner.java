package org.generation.italy.esempiCorso.inheritance.geometry;

public class mainRunner {
    public static void main(String[] args) {

        Triangolo triangle = new Triangolo(3,2);
        Rettangolo rectangle = new Rettangolo(2, 10);

        System.out.println(triangle.calcolaArea(3,5));
        System.out.println(rectangle.calcolaArea(5,7));
    }
}
