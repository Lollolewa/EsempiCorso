package org.generation.italy.esempiCorso.ravenclaw.arte;

import java.util.ArrayList;
import java.util.List;

public class Collezione {

    private String nome, luogo;
    List<OperaDArte> opere = new ArrayList<>();

    public Collezione(String nome, String luogo, List<OperaDArte> opere) {
        this.nome = nome;
        this.luogo = luogo;
        this.opere = opere;
    }

    public void aggiungiOpere(OperaDArte x){
        opere.add(x);
    }

    public String toString(){
        String list = "";
        for(OperaDArte a : opere){
            list+=a;
            list+="\n";
        }return list;
    }
}
