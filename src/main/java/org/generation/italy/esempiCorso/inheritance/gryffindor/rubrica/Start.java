package org.generation.italy.esempiCorso.inheritance.gryffindor.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<Contatto> contacts = new ArrayList<>();
        contacts.add(new Contatto("Mimmo", "idk", "346758394"));
        contacts.add(new Contatto("Lollo", "uigdwf", "9467542598"));
        Rubrica rubrica = new Rubrica(contacts);
        rubrica.aggiungiContatto(new Contatto("Gvng", "Jjjj", "492856425"));
        rubrica.rimuoviContatto(contacts.get(1));

        System.out.println(rubrica.toString());
    }
}
