package org.generation.italy.esempiCorso.inheritance.forme;

public class Main {
    public static void main(String[] args) {
        Cerchio cerchio = new Cerchio(5);
        //System.out.printf("%Cerchio:%nArea: %f %nPerimetro: %f %n",cerchio.calcolaArea(),cerchio.calcolaPerimetro());
        System.out.println("\nCerchio: \n" + "Area: " + cerchio.calcolaArea() + "\nPerimetro: " + cerchio.calcolaPerimetro());


        Rettangolo rettangolo = new Rettangolo(4, 7);
        //System.out.printf("%nRettangolo:%nArea: %f %nPerimetro: %f %n",rettangolo.calcolaArea(),rettangolo.calcolaPerimetro());
        System.out.println("\nRettangolo: \n" + "Area: " + rettangolo.calcolaArea() + "\nPerimetro: " + rettangolo.calcolaPerimetro());
    }
}