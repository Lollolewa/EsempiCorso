package org.generation.italy.esempiCorso.griffindor.eserciziCollection.rubrica;
import java.util.List;

public class Rubrica {
    List<Contatto> rubrica;

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
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto.getTelefono();
            }
        }
        return "Contatto non trovato. Prova con un altro nome o cognome. 1234567890";
    }
    @Override
    public String toString() {
        String result = "Contenuto Rubrica:\n";
        for(Contatto contatto : rubrica) {
            result += contatto;
            result += "\n";
        }
        return result;
    }
}

