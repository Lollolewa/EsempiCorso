package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Start {
    public static void main (String[] args){
        // collezioni --> insieme di elementi
        // array, struttura dati che è ordinata , contiene primitivi, dimensioni fissa

        String [] nomi = new String[10];
        nomi[0] = "Pino";

        // interfaccia Collection; contiene metodi di utilità per lavorare sulle collezioni
// List: insieme di elementi ordinati che hanno una dimensione ordinata

//Iterable rappresenta una sequenza di oggetti -> Hai un prossimo elemento? Dammelo. Da non usare con le liste perche non ha i metodi necessari

// List è una Collection con il senso dell'ordinamento


     // interfaccia Collection, contiene al suo interno metodi di utilità per lavorare sulle collezioni
        // insieme di elementi ordinati, hanno una dimensione variabile
        List<String> nomiClasse = new ArrayList<String>(); //polimorfismo
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");
   //List<String> names = List.of("Pino");
   //List<String> names = new ArrayList<>(List.of("Pino"));
        // diversi metodi per aggiungere


        //nomiClasse.remove("Lina");
        //nomiClasse.remove(1);
        //per rimuovere

        String lina = nomiClasse.get(1);

        System.out.println(nomiClasse.get(1));
        System. out.println(lina);
        for(int i = 0; i < nomiClasse. size(); i++) {
            System.out.println(nomiClasse.get(i));
        }
        //for each
        // s -> singolo elemento che sto scorrendo
        for(String pippo : nomiClasse) { //collezione
            System.out.println(pippo);
        }
/////////////////////////////////////////////////////////////////////////////////



        // LinkedList, più performante nell'inserimento e rimozione
        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto(  "pane",  1));
// il prodotto viene wrappato dentro un altro oggetto
// il nuovo oggetto conterrà il prodotto, più 2 reference, una al prodotto precedente e una al prodotto successivo
// prodotto1 <- > prodotto2 <- > prodotto3

// prodotto1[null, prodotto1, rProdotto2]
// prodotto2[rProdotto1, prodotto2, rProdotto3]
// prodotto3[rProdotto2, prodotto3, null]

 /////////////////////////////////////////////////////////////////////////

        // set
// set insieme di elementi però non è ordinato e non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers. add(19);
        //stampa 2 oggetti perché non ammette due duplicati

        Set<String> saluti = new HashSet<>();
        saluti. add("ciao");
        saluti.add("hello");
        saluti.add("ciao");



        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto(  "pane",  1));
        prodotti.add(new Prodotto(  "pane", 1));
        System.out.println(prodotti.size());

        List<String> result = findStartingWiths(List.of());

        //stampa 2 perchè hai creato due prodotti, due oggetti diversi che puntano a due indirizzi diversi
       //se due gggetti hanno lo stesso stesso contenuto informatico, il valore delle due variabili è identico, non e detto che siang lo stesso oggetto, SPOILER NON LO SONO

        String s1 = "pippo";
        String s2 = "pippo";
        //String s2 = new String("pippo"); SE METTO QUESTA DA COME RISULTATO FALSE
        System.out.println(s1 == s2); //può stampare true o false
        //dovrebbe stampare false perchè sta paragonando due indirizzi, non i due oggetti,
        //stama true perché java tratta le stringhe come primitive
        //stampa true perché non ho creato due stringhe, s2 non punta ad un nuovo oggetto ma ad s1
        //in java le stringhe sono immutabili perchè altrimenti non sarebbe possibile che piu stringhe punting alla stessa reference
        s1= s1 + "ciao"; //viene creata un altra stringa che combina s1 e ciao
        //ogni volta che concateni stringhe ne crei altre nuove
        s1= "pluto"; //non sto cambiando la stringa, sto cambiando il puntatore di s1

        Prodotto p1 = new Prodotto(  "bicicletta", 100);
        Prodotto p2 = new Prodotto( "bicicletta",  100);
        System.out.println(p1 == p2); //questo stampa false perche stai paragonando le reference




        //public static List<String> findStartingWithS (Iterable<String> ){
        // posso sempre castare dalla superclasse alla sottoclasse, ma non viceversa
        //        List<String> paroleRitorno = new ArrayList<>(); // il polimorfismo è nostro amico
         //   For(String parola : stringhe){
        //    if(parola.charAt(0) == 's') {
         //       paroleRitorno.add(parola);
          //  }
        //}
         //    return paroleRitorno;
    //}


        public static List<String> findStartingWithS(ArrayList<String> stringhe) {
            List<String> paroleRitorno = new ArrayList<>();
            for (String parola : stringhe) {
                if (parola.charAt(0) == 's') {
                    paroleRitorno.add(parola);
                }
            }
            return paroleRitorno;
        }

    }
}



