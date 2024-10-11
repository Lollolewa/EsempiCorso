package org.generation.italy.esempiCorso.inheritance.geometria;

public class Avvio {
    public static void main(String[] args) {
        Triangolo t1 = new Triangolo(20,10);
        Rettangolo r1 = new Rettangolo(10,2);

        System.out.println(t1.toString());
        System.out.println(r1.toString());
    }
}
