package org.generation.italy.esempiCorso.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {

    ArrayList<Contatto> contatti = new ArrayList<>();

    public void aggiungiContatto(String nome, String cognome, String numero){
        contatti.add(new Contatto(nome, cognome, numero));

    }
    public void rimuoviContatto(String nome, String cognome){
        contatti.removeIf(cont -> cont.getNome().equals(nome) && cont.getCognome().equals(cognome));
    }

    public String cercaContatto(String nome, String cognome){
        for(Contatto cont : contatti){
            if(cont.getNome().equals(nome) && cont.getCognome().equals(cognome)) {
                return cont.getTelefono();
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder listaContatti = new StringBuilder("Lista contatti: \n");
        for(Contatto cont : contatti){
            listaContatti.append(cont.getNome()).append(" ").append(cont.getCognome()).append(" ").append(cont.getTelefono()).append("\n");
        }
        return listaContatti.toString();
    }
}


