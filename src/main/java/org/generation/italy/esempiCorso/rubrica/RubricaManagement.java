package org.generation.italy.esempiCorso.rubrica;

public class RubricaManagement {
    public static void main(String[] args) {

        Rubrica rubrica = new Rubrica();

        rubrica.aggiungiContatto("Alessia", "Pallavera", "123456789");
        rubrica.aggiungiContatto("Giuseppe", "Barchetta", "987654321");

        System.out.println(rubrica.toString());

        rubrica.rimuoviContatto("Alessia", "Pallavera");
        System.out.println("Stampa rimozione contatto");
        System.out.println(rubrica.toString());

        rubrica.aggiungiContatto("Aless", "Pallavera", "123456789");
        System.out.println("Stampa aggiunta contatto");
        System.out.println(rubrica.toString());

        System.out.println(rubrica.cercaContatto("Alessia", "Pallavera"));


    }
}
