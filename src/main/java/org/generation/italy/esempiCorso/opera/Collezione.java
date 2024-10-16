package org.generation.italy.esempiCorso.opera;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    public String nome;
    public String luogo;
    public List<OperaDarte> operaDartes;

    public Collezione(String nome,String luogo,List<OperaDarte> operaDartes){
        this.nome=nome;
        this.luogo=luogo;
        this.operaDartes=operaDartes;

    }


    public void aggiungiOperaDarte(OperaDarte opera){
      operaDartes.add(opera);
    }

    public void stampCollezione(){
        System.out.println("Collezione: " + nome + " Luogo: " + luogo);
        for(OperaDarte opera : operaDartes){
            System.out.println("Titolo: " + opera.titolo + " " + "Artista: " + opera.artista);
        }
    }

}
