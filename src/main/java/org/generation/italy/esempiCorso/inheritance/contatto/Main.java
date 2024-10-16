package org.generation.italy.esempiCorso.inheritance.contatto;

public class Main {
    public static void main(String[] args) {

        //optional, wrapper, una scatola che può avere dentro qualcosa, come puo non averla


        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Mario","Fargi","3285626565");
        rubrica.aggiungiContatto("Loris","Canig","3285626565");

        rubrica.rimuoviContatto("Loris","Canig");
        System.out.println("Rubrica dopo la rimozione:");
        System.out.println(rubrica);

    }


}
