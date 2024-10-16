package org.generation.italy.esempiCorso.ravenclaw.rubrica;

public class Start {
    public static void main(String[] args) {

        Rubrica rubrica = new Rubrica();

        rubrica.aggiugniContatto("Maria","Rossa","21313131231");
        rubrica.aggiugniContatto("Feno","lai","56465464646");
        rubrica.aggiugniContatto("Gino","boi","32424342342");

        rubrica.rimuoviContatto("Gino", "boi");

        System.out.println(rubrica.toString());

        System.out.println(rubrica.cercaContatto("Feno", "lai"));

    }
}
