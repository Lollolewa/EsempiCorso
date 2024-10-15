package org.generation.italy.examples.interfaces;

import java.util.*;

public class Start {
    public static void main(String[] args) {
        // collezioni ==> insieme di elementi
        // puo far pensare agli array, struttura dati che puo contenere anche dati primitivi
        String[] nomi = new String[10];
        nomi[0]= "Pino";
        // interfaccia collection, contiene al suo interno metodi di utilita per lavorare sulle collezioni
            // rappresenta una sequenza di oggetti
        // list permette di interagire maggiormente.
        List<String> nomiClasse = new ArrayList<>(); //polimorfismo

            nomiClasse.add("Pino");
            nomiClasse.add("Lina");

            nomiClasse.remove("Lina");


            System.out.println(nomiClasse);
            String lina = nomiClasse.get(0);
            for (int i=0; i< nomiClasse.size(); i++){
                System.out.println(nomiClasse.get(i));
            }
            //for each per le liste
            //  s= elemento che sto scorrendo          nome collez = nomiclasse
            // per ogni stringa s contenuta in nomi classe.
            for(String s : nomiClasse){
                System.out.println(s);
            }


        List<String> listlink = new LinkedList<>();
            listlink.add("s"); // ogni elemento che viene aggiunto si chiama nodo
        Prodotto p1 = new Prodotto("pane",1);
        Prodotto p2 = new Prodotto("pane", 1);
        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(p1);
        prodotti.add(p2);
        System.out.println(prodotti.size()); // stampa lo stesso, perche sono oggetti diversi puntano a indirizzi diversi.
        //boolean r = p1.equals(p2); //ereditato da Object
        //System.out.println(r); //due oggetti uguali devono avere HashCode uguali, due oggetti per cui equals da true, devono avere stesso HashCode
        //Prodotto p3 = p1;
        //System.out.println(p3.equals(p1));
        //System.out.println(p3.hashCode());
        //System.out.println(p1.hashCode());
        //System.out.println(p1.equals(p2));
        //System.out.println(p1.hashCode() == p2.hashCode());


        //List<String> result = findStartingWithS(List.of())
    }

    public static List<String> findStartingWithS(ArrayList<String> stringhe){
        List<String> paroleRitorno = new ArrayList<>();
        for(String parola : stringhe){
            if(parola.charAt(0) == 's'){
                paroleRitorno.add(parola);

            }
        }
        return paroleRitorno;
    }


}
