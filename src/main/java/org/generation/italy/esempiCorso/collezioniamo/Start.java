package org.generation.italy.esempiCorso.collezioniamo;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class Start {
    public static void main(String[] args) {
        // Esempio di LinkedList
        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("Caciocavallo", 5));

        // Esempio di HashSet
        Set<String> saluti = new HashSet<>();
        saluti.add("ciao");
        saluti.add("hello");
        saluti.add("hi");

        for (String s : saluti) {
            System.out.println(s);
        }

        // HashSet di prodotti
        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("Pane", 2));
        prodotti.add(new Prodotto("Pane", 2)); // Questo non verrà aggiunto, poiché gli oggetti sono distinti
        System.out.println("Dimensione del Set di prodotti: " + prodotti.size());

        // Stampa i prodotti
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }

        // Chiamata del metodo findStartingWithS
        List<String> result = findStartingWithS(List.of("casa", "cane", "scopa", "gatto"));
        System.out.println("Parole che iniziano con 's': " + result);
    }

    // Metodo per trovare le parole che iniziano con 's' Ignorance is Bliss
    public static List<String> findStartingWithS(Iterable<String> stringa) {
        List<String> wordsOutput = new ArrayList<>();
        for (String parola : stringa) {
            if (parola.charAt(0) == 's') {
                wordsOutput.add(parola);
            }
        }
        return wordsOutput;
    }
}

// Collezioni = Insieme di elementi
        // Arraay = Struttura dati che è ordinata, contiene primitivi, dimensione fissa.
        // String[] nomi = new String[10];
        // nomi[0] = "Pippo";

        // Interfaccia Collection, contiene al suo interno metodi di utilità per lavorare sulle collezioni.
        // list
        // Insieme di elementi ordinati, hanno una dimensione variabile.
        // Iterable rappresenta una sequenza di oggetti, se ha un prossimo elemento me lo da. Da non usare con le liste.
        // List<String> nomiClasse = new ArrayList<String>(); //arrayList poliformando...
        // nomiClasse.add("Pippo");
        // nomiClasse.add("Pluto");
        // nomiClasse.remove(1);
        // nomiClasse.remove("Pluto");
        // String lina = nomiClasse.get(1);

        // System.out.println(nomiClasse);
        // System.out.println(lina);
        // System.out.println(nomiClasse.get(1));

        // for(int i=0; i<nomiClasse.size(); i++){
        // System.out.println(nomiClasse.get(i));
        // }
    // for each
        //s = singolo elemento che sto scorrendo
        // for(String pippo: nomiClasse){
        // System.out.println(pippo);
        // }
        // Il prodotto viene wrappato dentro un altro oggetto
        // Il nuovo oggetto conterra il prodotto, piu due reference, un al prodotto precedente e una al successivo.
        // prodotto1 <-> al prodotto2 <-> al prodotto3


