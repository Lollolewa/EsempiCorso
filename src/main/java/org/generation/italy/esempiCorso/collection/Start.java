package org.generation.italy.esempiCorso.collection;

import java.util.*;

public class Start {
    public static void main(String[] args) {

        //ARRAY - DIMENSIONE FISSA
        String[] nomi = new String[10];
        nomi[0] = "Pino";

        //INTERFACCIA COLLECTION, CONTIENE AL SUO INTERNO MEDODI DI UTILITA PER LAVORARE SULLE COLLEZIONI.

        //LIST - NON HA LIMITE DI GRANDEZZA - INSIEME DI ELEMENTI ORDINATI, HANNO UNA DIMENSIONE VARIABILE
        List<String> nomiClasse =  new ArrayList<>();
        nomiClasse.add("Pino");
        nomiClasse.add("Lino");
        nomiClasse.add("Gino");
        nomiClasse.add("Tinos");
//        nomiClasse.remove(1); //remove sia per indice che per oggetto.

//        List<String> names = List.of("Pino","Gino"); //non modificabile
        List<String> names = new ArrayList<>(List.of("Pino","Gino","Lina")); //popolamento lista

        //un array list compatta direttamente senza lasciare spazi vuoti
        System.out.println(nomiClasse);
        System.out.println(names);

        System.out.println(nomiClasse.get(1));

        String Gino = nomiClasse.get(1);

        System.out.println(Gino);
        System.out.println("\n");

        for (String i : nomiClasse) { //ENHANCED FOR TO PRINT ELEMENTS OF A LIST
            System.out.println(i);
        }
        System.out.println("\n");

        //SET
        //non ordinato e non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(21);
        numbers.add(19); //viene automaticamente omesso

        System.out.println(numbers);

        Set<String> saluti = new HashSet<>();
        saluti.add("hello");
        saluti.add("Hola");
        saluti.add("Ciao");

        System.out.println(saluti);

        Set<Prodotto> prodotti = new HashSet<>();

        prodotti.add((new Prodotto("Pane",22)));

        String s1 = "pippo";
        String s2 = "pippo";
        System.out.println(s1==s2);

        Prodotto p1 = new Prodotto("Bicicletta",100);
        Prodotto p2 = new Prodotto("Bicicletta",100);
        System.out.println(p1==p2);

        List<String> result = findS(nomiClasse);

    }

    public static List<String> findS (Iterable<String> stringhe){
        List<String> parolaRitorno = new ArrayList<>();
        for(String s : stringhe)        {
            if (s.charAt(0)=='s'){
                parolaRitorno.add(s);
            }
        } return  parolaRitorno;
    }



}