package org.generation.italy.esempiCorso.inheritance.geometria;

public class Geometra {
    public static void main(String[] args) {

       Triangolo trino = new Triangolo(23, 45);
       Rettangolo recto = new Rettangolo(20, 10);

        System.out.println(trino.toString());
        System.out.println("\n");
        System.out.println(recto.toString());


    }
}
