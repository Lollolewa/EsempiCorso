package org.generation.italy.esempiCorso.ravenclaw.rubrica;

public class Start {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Mario", "Rossi", "0123456789");
        System.out.println(rubrica.toString());

        rubrica.rimuoviContatto("Maria", "Rossa", "0123456789");
        rubrica.cercaContatto("Mario", "Rossi", "0123456789");
        rubrica.aggiungiContatto("Maria", "Rossa", "0123456789");
    }
}