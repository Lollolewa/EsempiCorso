package org.generation.italy.esempiCorso.inheritance.geometria;

public class main {
    public static void main(String[] args) {
        Triangolo tr1 = new Triangolo(5, 6);
        Rettangolo ret = new Rettangolo(3, 1);
        System.out.println(tr1.toString());
        System.out.println(ret.toString());
    }
}
