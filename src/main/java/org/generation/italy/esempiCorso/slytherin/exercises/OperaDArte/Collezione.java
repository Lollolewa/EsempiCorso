package org.generation.italy.esempiCorso.slytherin.exercises.OperaDArte;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    String nome;
    String cognome;
    List<OperaDArte> opere = new ArrayList<>();

    public void inserire(OperaDArte o){
        opere.add(o);
    }

    public void stampa(){
        for(int i=0; i< opere.size();i++){
            System.out.println(opere.get(i).titolo + " " +  opere.get(i).artista);
        }
    }

}
