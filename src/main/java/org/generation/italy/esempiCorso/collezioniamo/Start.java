package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {

    public static void main(String[] args) {
        // collezioni -> insieme di elementi
        // array, struttura dati che è ordinata, contiene primitivi, dimensione fissa
        String[] nomi = new String[10];
        nomi[0] = "Pino";

        // interfaccia Collection, contiene al suo interno metodi di utilità per lavorare sulle collezioni

        //list
        // insieme di elementi ordinati, hanno una dimensione variabile
        List<String> nomiClasse = new ArrayList<>(); // arraylist
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        List<Integer> numeri = new ArrayList<>();

        //List<String> names = List.of("Pino");
        //List<String> names = new ArrayList<>(List.of("Pino"));

        //nomiClasse.remove("Lina");
        //nomiClasse.remove(1);

        String lina = nomiClasse.get(1);

        System.out.println(nomiClasse.get(1));
        System.out.println(lina);

        for(int i = 0; i < nomiClasse.size(); i++){
            System.out.println(nomiClasse.get(i));
        }

        //for each
        //  s -> singolo elemento che sto scorrendo
        for(String pippo : nomiClasse){ //collezione
            System.out.println(pippo);
        }

        //-------------------------------

        // LinkedList, più performante nell'inserimento e rimozione
        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("pane",1));
        // il prodotto viene wrappato dentro un altro oggetto
        // il nuovo oggetto conterrà il prodotto, più 2 reference, una al prodotto precedente e una al prodotto successivo
        // prodotto1 <-> prodotto2 <-> prodotto3
        //
        // prodotto1[null, prodotto1, rProdotto2]
        // prodotto2[rProdotto1, prodotto2, rProdotto3]
        // prodotto3[rProdotto2, prodotto3, null]


        //-----------------------------------------
        // set
        // set insieme di elementi però non è ordinato e non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(19);

        Set<String> saluti = new HashSet<>();
        saluti.add("ciao");
        saluti.add("hello");
        saluti.add("ciao");

        for(String s : saluti){
            if(s.equals("hello")){

            }
        }



    }

}
