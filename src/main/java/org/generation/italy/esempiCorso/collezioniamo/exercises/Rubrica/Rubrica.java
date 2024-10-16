package org.generation.italy.esempiCorso.collezioniamo.exercises.Rubrica;

import java.util.*;

public class Rubrica
{
    // liste -> insieme di elementi di dimensione variabile, ordinati
    // set -> insieme di elementi non ordinati, non ammette duplicati

    List<Contatto> contatti = new ArrayList<>();
    Set<Contatto> setContatti = new HashSet<>();

    public void rimuoviContattoFromSet(Contatto c){
        setContatti.remove(c);
    }

    public String cercaContattoFromSet(Contatto c){
        for(Contatto cc : setContatti){
            if(cc.equals(c))
                return cc.getNumeroTelefono();
        }
        return null;
    }

    public void aggiungiContatto(String nome, String cognome, String telefono){
        contatti.add(new Contatto(nome, cognome, telefono));
    }

    public void rimuoviContatto(String nome, String cognome){
        // trovare il contatto
        // variabileCheStoScorrendo : lista
        for(Contatto c : contatti){
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                contatti.remove(c);
            }
        }
    }

    public String cercaContatto(String nome, String cognome){
        String nT = null;
        for(Contatto c : contatti){
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                nT = c.getNumeroTelefono();
                break;
            }
        }
        return nT;
    }
    // optional, potrebbe avere dentro una stringa come no
    public Optional<String> cercaContattoOptional(String nome, String cognome){

        for(Contatto c : contatti){
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                return Optional.of(c.getNumeroTelefono()); // ritorno optional farcito
            }
        }
        return Optional.empty(); // ritorno optional vuoto
    }

    @Override
    public String toString() {
        String res = "Rubrica\n";
        res+="====================================================\n";
        for(Contatto c : contatti){
            res += c.toString() + "\n";
        }
        return res;
    }
}
