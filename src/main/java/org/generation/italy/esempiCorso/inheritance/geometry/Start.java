package org.generation.italy.esempiCorso.inheritance.geometry;

public class Start {
    public static void main(String[] args) {
        Triangolo triangolo = new Triangolo(4,8);
        Rettangolo rettangolo = new Rettangolo(5,9);

        System.out.println(triangolo.toString());
        System.out.println(rettangolo.toString());
    }
}
