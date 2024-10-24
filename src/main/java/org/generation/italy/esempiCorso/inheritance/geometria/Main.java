package org.generation.italy.esempiCorso.inheritance.geometria;

public class Main {
    public static void main(String[] args) {
        Triangolo t1 = new Triangolo(10, 10, "triangolo", 3);
        Rettangolo r1 = new Rettangolo(10, 10, "rettangolo", 4);
        int areat1 = t1.calculateArea();
        int arear1 = r1.calculateArea();

        System.out.println("Il " + t1.getName() + " ha base " + t1.base + " e altezza " + t1.altezza + ". La sua area è " + t1.calculateArea() +
                        "\nIl " + r1.getName() + " ha base " + r1.base + " e altezza " + r1.altezza + ". La sua area è " + r1.calculateArea());

    }
}
