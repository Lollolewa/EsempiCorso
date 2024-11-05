package org.generation.italy.esempiCorso.gryffindor.esercizioRubrica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rubrica {
    //liste -> insieme di elementi di dimensione variabile, ordinato
    //set   -> insieme di elementi non ordinati, non ammette duplicati

    List<Contatto> contatti = new ArrayList<>();
    Set<Contatto> setContatti = new HashSet<>();

    //------------------------------METODI PER LISTA------------------------------
    public void aggiungiContatto(String nome, String cognome, String telefono) {
        contatti.add(new Contatto(nome, cognome, telefono));
    }

    public void rimuoviContatto(String nome, String cognome) {
        //trovare contatto
        //rimuoverlo
        //variabile che sto scorrendo : lista
        for (Contatto contatto : contatti) {
            if (contatto.getCognome().equals(nome) && contatto.getCognome().equals(cognome)) {
                contatti.remove(contatto);
            }
        }
    }

    public String cercaContatto(String nome, String cognome) {
        String nt = null;
        for (Contatto c : contatti) {
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                nt = c.getNumeroTelefono();
                break;
            }
        }
        return nt;
    }

    //------------------------------METODI PER SET------------------------------
    public void rimuoviContattoFromSet(Contatto c) {
        setContatti.remove(c);
    }

    public String cercaContattoFromSet(Contatto c) {
        for (Contatto cc : setContatti) {
            if (cc.equals(c)) {
                return cc.getNumeroTelefono();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "Rubrica\n";
        res += "====================================";
        for (Contatto c : contatti) {
            res += c.toString() + "\n";

        }
        return res;
    }
}
