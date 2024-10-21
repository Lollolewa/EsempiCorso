package org.generation.italy.esempiCorso.inheritance.geometry;

public class GeometriaPro {
    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo(10, 15);
        Triangolo t1 = new Triangolo(8, 14);

        System.out.println(r1.calcolaArea(5,2));
        System.out.println(t1.calcolaArea(7,8));
    }
}
