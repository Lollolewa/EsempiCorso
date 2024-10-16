package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioNumeri;

import java.util.ArrayList;
import java.util.List;

public class Rubrica{
    public List<Contatto> contatti = new ArrayList<>();


    public void aggiungiContatto(String nome, String cognome, String number){
        contatti.add(new Contatto(nome, cognome, number));
    }

    public void rimuoviKontatto(String nome, String cognome){
        contatti.removeIf(contatto -> contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome));  // Rimuove con removeIf senza ciclo
        /*for(Contatto cont : contatti){
            if(cont.nome.equalsIgnoreCase(nome) && cont.cognome.equalsIgnoreCase(cognome)){
                contatti.remove(cont);
            }*/
    }


    public String Kerca(String nome, String cognome){
        String numero = null;
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
                numero = contatto.getNumber();
            }
        }
        return numero;
    }

    @Override
    public String toString() {
        String s = "=========================\nLista contatti\n=========================\n";
        for(Contatto cont : contatti){
            s +=  cont.toString();
            s += "\n\n";
        }
        return s;
    }
}
