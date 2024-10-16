package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.rubricaLista;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> rubrica = new ArrayList<>();

    public void aggiungiContatto(String nome, String cognome, String numero) {
        rubrica.add(new Contatto(nome, cognome, numero));
    }

    public void rimuoviContatto(String nome, String cognome) {
        rubrica.remove(new Contatto(nome, cognome, cerca(nome, cognome)));
    }

    public String cerca(String nome, String cognome) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto.getNumero();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "Rubrica:\n";

        for (Contatto contatto : rubrica) {
            result += contatto + "\n";
        }

        return result;
    }

}
