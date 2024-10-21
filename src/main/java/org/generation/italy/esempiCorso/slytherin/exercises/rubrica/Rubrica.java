package org.generation.italy.esempiCorso.slytherin.exercises.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> contatti = new ArrayList<>();

    public void aggiungiContatto (String nome, String cognome, String telefono) {
        contatti.add(new Contatto(nome, cognome, telefono));
    }
    public void rimuoviContatti (String nome, String cognome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)){
                contatti.remove(contatto);
            }
        }
    }
    public String cercaContatti (String nome, String cognome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto.getNumeroTelefono();
            }
        }
        return null;
    }
    public String toString() {
        String res = "";
        for (Contatto contatto : contatti) {
            res += contatto.toString();
        }
        return res;
    }
}
