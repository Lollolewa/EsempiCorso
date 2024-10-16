package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioNumeri;

public class Main {
    public static void main(String[] args) {

        Rubrica r = new Rubrica();
        r.aggiungiContatto("Samuele", "Celletti", "3459305441");
        r.aggiungiContatto("Alessia", "Pallavera", "43253626");
        r.aggiungiContatto("Pietro", "Marinari", "987654321");
        System.out.println(r.toString());
        r.rimuoviKontatto("Pietro", "Marinari");
        System.out.println(r.toString());
        System.out.println(r.Kerca("aa", "Celletti"));
        System.out.println(r.Kerca("samuele", "celletti"));

    }
}
