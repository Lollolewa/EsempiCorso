package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {
    public static void main(String[] args) {
        String[] nomiClasseMarcio = new String[10];

        // interfaccia Collection; contiene metodi di utilità per lavorare sulle collezioni
        // list: insieme di elementi ordinati che hanno una dimensione ordinata

        List<String> nomiClasse = new ArrayList<>();
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        List<Integer> numeri = new ArrayList<>();

        // nomiClasse.remove(1);
        // nomiClasse.remove("Lina");

        String lina = nomiClasse.get(1);

//        for (int i = 0; i < nomiClasse.size(); i ++) {
//            System.out.println(nomiClasse.get(i));
//        }

        // for each:
        // sulla sinistra ho il singolo elemento che sto scorrendo || sulla destra ho il nome della mia collezione
        for (String s : nomiClasse) { // per ogni s contenuta in nomiClasse
            System.out.println(s);  // printami s
        }

        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("pane", 4));
        // il prodotto viene wrappato dentro un altro oggetto
        // il nuovo oggetto conterrà l'oggetto in questione + 2 reference; una all'oggetto precedente, una al successivo
        // prodotto1 <-> prodotto2 <-> prodotto3
        //
        // prodotto1[null, prodotto1, rprodotto2]
        // prodotto 2[rprodotto1, prodotto2, rprodotto3]
        // prodotto 3[rprodotto2, prodotto3, null]

        // set:
        // insieme di elementi non ordinato e non ammette duplicati

        Set<Integer> numSet = new HashSet<>();
        numSet.add(19);
        numSet.add(20);
        numSet.add(19); // questo verrà ignorato perchè i Set non ammettono duplicati

        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("pane", 4));
        prodotti.add(new Prodotto("pane", 4));

        System.out.println(prodotti.size()); // qui stampa 2 perchè nonostanti i due oggetti abbiano lo stesso contenuto
                                             // sono comunque e oggetti diversi con 2 reference diverse
        String s1 = "Pippo";
        String s2 = "Pippo";
        System.out.println(s1 == s2);

        List<String> result = findStartingWithS(List.of("Mario", "johnny", "cane", "gatto", "Spook", "Sara", "sogno"));
        System.out.println(result);
    }
    public static List<String> findStartingWithS (Collection<String> stringhe) {
        List<String> wordsOutput = new ArrayList<>();
        for (String parola : stringhe){
            if (parola.charAt(0) == 's' || parola.charAt(0) == 'S') {
                wordsOutput.add(parola);
            }
        }
        return wordsOutput;
    }
}