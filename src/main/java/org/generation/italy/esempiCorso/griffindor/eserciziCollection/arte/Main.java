package org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        collezione.nome = "Opere del GranCacioRomano";
        collezione.luogo = "Roma";
        collezione.opere = new ArrayList<>();

        collezione.aggiungiOpera(new Quadro("Leonardo da pippo", "Mona Lisa", 100,60));
        collezione.aggiungiOpera(new Scultura("Leonardo da Vinci", "GigiELele", 100,60, 25));
        collezione.stampaCollezione(collezione.nome, collezione.luogo, collezione.opere);


        collezione.opere.get(1).compareToString(collezione.opere.get(0));// true
        collezione.compareToStringBis(collezione.opere.get(0), collezione.opere.get(1));//
        System.out.println(collezione.opere.getFirst());
        System.out.println(collezione.opere.getFirst());
    }

}
