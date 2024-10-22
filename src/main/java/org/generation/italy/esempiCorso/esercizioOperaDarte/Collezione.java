package org.generation.italy.esempiCorso.esercizioOperaDarte;

import java.util.ArrayList;
import java.util.List;

public class Collezione {

    String nome, luogo;

    public Collezione(String nome, String luogo){

        this.nome = nome;
        this.luogo = luogo;
    }

    List<OperaDArte> opereDArte = new ArrayList<>();

    public void inserisciOpera(OperaDArte opera){

        opereDArte.add(opera);
    }

    public void stampaCollezione(){

        for(OperaDArte opera : opereDArte){
            System.out.println(opera.toString());
        }
    }
}
