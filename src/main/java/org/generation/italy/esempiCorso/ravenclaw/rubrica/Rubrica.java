package org.generation.italy.esempiCorso.ravenclaw.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    List<Contatto> conttatti = new ArrayList<>();


    public void addContatto(String nome, String cognome, String numTelefono){
        //Contatto c = new Contatto(nome,cognome, numTelefono)
        conttatti.add(new Contatto(nome, cognome, numTelefono));
    }

    public void rimuoviContatto(String nome, String cognome){
        for(Contatto contatto : conttatti){
            if(contatto.getNome().equals(nome)&&contatto.getCognome().equals(cognome)){
                conttatti.remove(contatto);
            }
        }
    }
    public String cercaContatto(String nome, String cognome){
        String nt = "";
        for(Contatto contatto : conttatti){
            if(contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)){
                nt = contatto.getNumTelefono();
                break;
            }
        }
        return nt;
    }
    public String toString(){
        String res = "Rubrica\n";
        res+="================";
        for(Contatto contatto : conttatti){
            res += contatto.toString()+"\n";
        }
        return res;
    }
}
