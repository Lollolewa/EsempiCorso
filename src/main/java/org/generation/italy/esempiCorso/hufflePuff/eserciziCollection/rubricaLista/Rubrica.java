package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.rubricaLista;

import java.util.List;

public class Rubrica {
    private List<Contatto> rubrica;

    public Rubrica(List<Contatto> rubrica) {
        this.rubrica = rubrica;
    }

    public void aggiungiContatto(String nome, String cognome, String numero) {
        Contatto contatto = new Contatto(nome, cognome, numero);
        rubrica.add(contatto);
    }

    public void rimuoviContatto(String nome, String cognome) {
        Contatto contatto = new Contatto(nome, cognome, cerca(nome, cognome));
        rubrica.remove(contatto);
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
