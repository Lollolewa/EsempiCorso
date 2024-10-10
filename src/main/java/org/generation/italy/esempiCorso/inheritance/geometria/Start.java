package org.generation.italy.esempiCorso.inheritance.geometria;

public class Start{

    public static void main(String[] args){

        int base = 4;
        int altezza = 5;

        Triangolo t = new Triangolo(base, altezza);
        Rettangolo r = new Rettangolo(base, altezza);

        System.out.println(t.calcolaArea());
        System.out.println(r.calcolaArea());

    }
}
