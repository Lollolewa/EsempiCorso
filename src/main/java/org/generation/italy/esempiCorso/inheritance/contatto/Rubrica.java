package org.generation.italy.esempiCorso.inheritance.contatto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Rubrica {
    //Liste -> insieme di elementi di dimensione variabile,
    //Set -> insieme di elementi non ordinati e non ammette duplicati
    List<Contatto> contatti = new ArrayList<>();

    public void aggiungiContatto(String nome,String cognome,String numeroTelefono){
        //Contatto c = new Contatto(nome,cognome,numeroTelefono);
        contatti.add(new Contatto(nome,cognome,numeroTelefono));
    }

    public void rimuoviContatto(String nome,String cognome){
        //trovare contatto
        //rimuoverlo
        for(Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                contatti.remove(contatto);
            }
        }
    }
    public String cercaContatto(String nome,String cognome){
        String nt = null;
        for (Contatto contatto : contatti){
            if(contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)){
                nt=  contatto.getNumeroTelefono();
                break;
            }
        }
        return nt;
    }
    public Optional<String> cercaContattoOptional(String nome,String cognome){

        for (Contatto c: contatti){
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                return Optional.of(c.getNumeroTelefono()); //ritorno optional farcito
            }
        }
    }

    @Override
    public String toString() {
        String res = "Rubrica\n";
        res+= "--------------------\n";
        for (Contatto c : contatti) {
            res += c.toString() + "\n";
        }
        return res;

        }
}



