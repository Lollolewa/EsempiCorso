package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {
    public static void main(String[] args) {

        // List<Prodotto> prodotti = new ArrayList<>();
        // ---------------------------------
        List<String> listLink = new LinkedList<>(); // POLIMORFISMO
        // Collection<String> listLink = new LinkedList<>();
        // Iterable<String> listLink = new LinkedList<>();
        listLink.add("s");

        // -------------------------------------
        // SET
        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        // numbers.add(19); ERRORE, NON AMMETTE DUPLICATI

        Set<String> saluti = new HashSet<>();
        saluti.add("ciao");
        saluti.add("hello");
        // saluti.add("ciao"); ERRORE

//        for (String s : saluti) {
//            if (s.equals("hello")) {
//
//            }
//        }

        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("pane", 1));
        prodotti.add(new Prodotto("pane", 1));

        Prodotto p1 = new Prodotto("pane", 1);
        Prodotto p2 = new Prodotto("pane", 1);
        System.out.println(prodotti.size()); // ESCE 2 NON SONO LO STESSO OGGETTO
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        String s1 = "pippo";
        String s2 = "pippo";
        System.out.println(s1 == s2);

        //List<String> result = findStartingWithS(List.of("casa", "cipolla", "scopa", "lombrico"));
    }

    
    public static List<String> findStartingWithS(Iterable<String> words) {
        List<String> stringsWithS = new ArrayList<>();
        for (String word : words) {
            if (word.charAt(0) == 's') {
                stringsWithS.add(word);
            }
        }
        return stringsWithS;
    }



}
