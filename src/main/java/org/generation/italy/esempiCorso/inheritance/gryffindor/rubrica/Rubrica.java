package org.generation.italy.esempiCorso.inheritance.gryffindor.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> rubrica;

    public Rubrica (List<Contatto> rubrica) {
    this.rubrica = rubrica;
    }

    public void aggiungiContatto (Contatto contatto) {
        rubrica.add(contatto);
    }
    public void rimuoviContatto (Contatto contatto) {
        rubrica.remove(contatto);
    }
    public String cerca(String nome, String cognome) {
        for (Contatto c : rubrica) {
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                return c.getNumeroTelefonico();
            }
        }
        return null; //mai trovato quello che cercava
    }
    public String toString() {
        String result = "Contenuto Rubrica:\n";
        for (Contatto c : rubrica) {
            result += c;
            result += "\n";
        }
        return result;
    }//descrzione testuale dell'intera rubrica
}
