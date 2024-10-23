package org.generation.italy.esempiCorso.ravenclaw.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> contatti = new ArrayList<>();

    public void aggiungiContatto(String nome, String cognome, String numeroTelefono) {
        contatti.add(new Contatto(nome, cognome, numeroTelefono));
    }
    public void rimuoviContatto(String nome, String cognome, String numeroTelefono) {
        //   File      nome      Lista  quindi prende il file Contatto, gli do un nome contatto (o quello che voglio) e poi gli do la lista creata sopra
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                contatti.remove(contatto);
            }
        }
    }
    public String cercaContatto(String nome, String cognome, String numeroTelefono) {
        String numT = "";
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                numT = contatto.getNumeroTelefono();
                break;
            }
        }
        return numT;
    }
    @Override
    public String toString(){
        String res = "Rubrica";
        res += "================";
            for (Contatto contatto : contatti);
            return res;
    }
}