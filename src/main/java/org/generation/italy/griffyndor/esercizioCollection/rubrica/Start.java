package org.generation.italy.griffyndor.esercizioCollection.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<Contatto> contacts = new ArrayList<>();
        contacts.add(new Contatto("Mimmo","Rossi","3473826499"));
        contacts.add(new Contatto("Lollo","Verdi","2478927498"));
        Rubrica rubrica = new Rubrica(contacts);
        rubrica.aggiungiContatto(new Contatto("Riku","jjj", "3473826498"));
        rubrica.rimuoviContatto(contacts.get(1));
        rubrica.cerca("Mimmo","Rossi");
        System.out.println(rubrica.toString());
    }
}
