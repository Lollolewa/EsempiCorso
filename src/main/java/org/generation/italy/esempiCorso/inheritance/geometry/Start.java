package org.generation.italy.esempiCorso.inheritance.geometry;

public class Start {
    public static void main(String[] args){
        Rettangolo rettangolo = new Rettangolo(5,10);
        Triangolo triangolo = new Triangolo(20,30);
        System.out.println(triangolo.calcolaArea());
        System.out.println(rettangolo.calcolaArea());
    }
}
