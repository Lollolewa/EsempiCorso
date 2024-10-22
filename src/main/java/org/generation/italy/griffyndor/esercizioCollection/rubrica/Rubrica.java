package org.generation.italy.griffyndor.esercizioCollection.rubrica;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> rubrica;

    public Rubrica() {

    }

    public Rubrica(List<Contatto> rubrica) {
        this.rubrica = rubrica;
    }

    public void aggiungiContatto(Contatto contatto) {
        rubrica.add(contatto);

    }

    public void rimuoviContatto(Contatto contatto) {
        rubrica.remove(contatto);
    }

    public String cerca(String nome, String cognome) {
        for (Contatto c : rubrica) {
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                return c.getNumeroTelefonico();
            }
        }
        return null;
    }

    public String toString() {
        String print = "Contenuto rubrica:\n";
        for (Contatto c : rubrica) {
            print += c;
        }
        return print;
    }

}
