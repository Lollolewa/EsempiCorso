package org.generation.italy.esempiCorso.ravenclaw.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {

    List<Contatto> contatti = new ArrayList<>();

    public void aggiugniContatto(String nome, String cognome, String telefono){
        contatti.add(new Contatto(nome, cognome, telefono));
    }

    public void rimuoviContatto(String nome, String cognome){
        for(Contatto c : contatti){
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                contatti.remove(c);
                break;
            }
        }
    }

    public String cercaContatto(String nome, String cognome){
        String nT = null;
        for(Contatto c : contatti){
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)){
                 nT = c.getnTelefono();
                 break;
            }
        }
        return nT;
    }

    public String toString(){
        String res = "Rubrica\n";
        res+="====================================\n";
        for(Contatto c : contatti){
            res+= c.toString()+"\n";
        }
        return res;
    }
}
