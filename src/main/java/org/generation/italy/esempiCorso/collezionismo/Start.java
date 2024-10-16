package org.generation.italy.esempiCorso.collezionismo;

import java.util.*;

public class Start {
    public static void main(String[] args) {


        //collezioni -> insieme di elementi
        //array, struttore dati che è ordinato, contiene primitivi,dimensione fissa
        String[] nomi = new String[10];
        nomi[0] = "Pino";
        //iterable rappresenta una sequenza di oggetti, hai un prossimo elemento? dammelo, non ha metodi necessari
        //collection ha più metodi come add,remove
        //List è una collection con il senso dell'ordinamento

        //Interfaccia Collection, contiene al suo interno metodi

        //di utilità per lavorare sulle collezioni
        //insieme di elementi ordinati, hanno una dimensione variabile
        List<String> nomiClasse = new ArrayList<>();
        nomiClasse.add("Pino");
        nomiClasse.add("Luca");
        //nomiClasse.remove("Pino");
        //nomiClasse.remove(0);
        //add aggiungi, remove, rimuovi
        String lina = nomiClasse.get(1);
        for (int i = 0; i< nomiClasse.size();i++){
            System.out.println(nomiClasse.get(i));
        }
        //for each
        //  singolo elemento che sto scorrendo :  nomeCollezione
        for (String s : nomiClasse){
            System.out.println(s);
        }

        //per dare una dimensione ad una arrayList mettiamo .capacity

        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("Pane",1));
        //il prodotto viene wrappato dentro un altro oggetto
        //il nuovo oggetto conterrà il prodotto, piu 2 reference, una al prodotto precedente e uno al prodotto successivo
        // un riferimento al prodotto precedente e quello dopo
        // due oggetti uguali devono AVERE lo stesso hashCODE,




        //-------------------------------

        //set
        //set insieme di elementi però non è ordinato e non ammette duplicati
        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(19);
        System.out.println(numbers);

        Set<String> saluti = new HashSet<>();
        saluti.add("ciao");
        saluti.add("Hello");
        saluti.add("Ciao");

        System.out.println(saluti);
        //in java le stringhe sono immutabili,altrimenti non sarebbe possibile che piu stringhe puntino alla stessa reference

        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("Pane",2));
        prodotti.add(new Prodotto("Farina",100));

        List<String> result = findStartwhitS(List.of("Ciao","Serpente","Hola"));




    }


    public static List<String> findStartwhitS(Collection<String> stringhe) {
        List<String> nomiS = new ArrayList<>();
        for (String parola : stringhe) {
            if (parola.charAt(0) == 's') {
                nomiS.add(parola);
            }
        }
        return  nomiS;
    }
}