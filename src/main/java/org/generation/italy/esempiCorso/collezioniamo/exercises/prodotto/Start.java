package org.generation.italy.esempiCorso.collezioniamo.exercises.prodotto;

import java.util.*;

public class Start {
    public static void main(String[] args) {
        // collezioni -> insieme di elementi
        // array -> struttura dati che è ordinata, contiene primitivi e non, dimensione fissa.
        String[] nomi = new String[10];
        nomi[0] = "Pino";

        //ctrl+n apre la ricerca, cercando collection apre un'interfaccia che contiene al suo interno metodi d'utilità
        //per lavorare sulle collezioni

        //List
        //insieme di elementi ordinati, hanno una dimensione variabile, non contengono primitive ma solo oggetti (che possono contenere primitive (Integer>int))
        List<String> nomiClasse = new ArrayList<String>(); //ctrl+space dopo ciò che devi importare ti apre uno schema con le cose importabili
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        //List<String> nomiClasse = new ArrayList<>(100); // per dare una capacità iniziale all'arrayList possiamo scrivere la capacitàn all'interno delle parentesi
        //List<String> names = new ArrayList<>(List.of("Pino", "Pluto", "Gianni", "Franco")); // per non inserire uno a uno gli oggetti;


        //nomiClasse.remove(1); //sta togliendo in base all'indice, rimuoverà Lina;
        //nomiClasse.remove("Lina"); //sta togliendo in base all'oggetto, rimuoverà l'oggetto col nome Lina;
        System.out.println(nomiClasse);

        //per andare a prendere un elemento all'interno della lista, si usa .get(i);
        String lina = nomiClasse.get(1); //sta dando alla variabile lina il valore dell'elemento in posizione 1 dell'arraylist (lina);

        for(int i = 0; i < nomiClasse.size(); i++) { //per scorrere un array solitamente facciamo un normale for da 0 al massimo valore dell'array
            System.out.println(nomiClasse.get(i));
        }

        //for each
        // s -> singolo elemento che sto scorrendo;
        // : all'interno di;
        // nomiClasse -> nome Collezione;

        //for ( singolo elemento che sto scorrendo : nome Collezione )
        for(String s : nomiClasse) {  //per ogni Stringa s contenuta all'interno della mia collezione nomiClasse
            System.out.println(s); //stampa la stringa s
        }

        //------------------------------------------------------------------

        //LinkedList: più performante nell'inserimento e nella rimozione degli elementi.
        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("pane", 1));
        // l'oggetto che aggiungo (prodotto) viene wrappato dentro un altro oggetto
        // l'altro oggetto (il nuovo) avrà dentro il prodotto in posizione i +
        // un riferimento a ciò che c'è prima (i-1)               +
        // un riferimento a ciò che c'è dopo (i+1);

        //avrà quindi questa forma: prodotto1 <-> prodotto2 <-> prodotto3 <-> ecc...
        //prodotto1[null (ref i-1), prodotto1 (ref i), rprodotto2 (ref i+1)];
        //prodotto2 [rprodotto1 (ref i-1), prodotto2 (ref i), rprodotto 3 (ref i+1)];


        //--------------------------------------------------------------------

        //Set:
        //Il set non è una lista, è un insieme di elementi però non è ordinato e non ammette duplicati.

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(21);
        numbers.add(19); //i set non ammettono duplicati, dà errore

        System.out.println(numbers); //non stampa il secondo 19 perchè non accetta duplicati.

        Set<String> saluti = new HashSet<>();
        saluti.add("Ciao");
        saluti.add("Hello");
        saluti.add("Ciao");

        System.out.println(saluti); //non stampa il secondo Ciao perchè non accetta duplicati.

        for(String s : saluti) { //non essendo ordinato, nei set non possiamo usare un indice per ottenere il loro valore, perciò dobbiamo
            // scorrere tutto il set e mettere una condizione per ottenere il valore che vogliamo.
            if(s.equals("Hello")) {
                System.out.println(s);
            }
        }

        Set<Prodotto> prodotti = new HashSet<>();

        Prodotto p1 = new Prodotto("Pane", 1);
        Prodotto p2 = new Prodotto("Pane", 1);
        prodotti.add(p1);
        prodotti.add(p2);
        System.out.println("Size: " + prodotti.size()); //puntano a indirizzi diversi, quindi java non li vede come oggetti uguali, pur avendo le
                                            // variabili identiche;
        boolean r = p1.equals(p2); //il punto equals "base" controlla che se gli indirizzi sono uguali o meno, perciò ritorna comunque false
                                  // nonostante i prodotti, essenzialmente, siano uguali (hanno contenuto informativo uguale;
                                 // per risolvere il problema, si va all'interno della classe dell'oggetto e si overrida il metodo equals
        System.out.println(".equals = " + r); //aggiustando il .equals stamperà true, ma il size darà ancora 2 invece di 1.




        //-------------------------------------------------------------------------------------------------------------

        //se due oggetti hanno contenuto informativo uguale, ovvero hanno i valori delle variabili identici,
        //non è detto che siano lo stesso oggetto.

        String s1 = "Pippo";
        String s2 = "Pippo";
        System.out.println(s1==s2); // dovrebbe stampare false perchè sta paragonando due indirizzi, non i due oggetti;
                                   // stampa true perchè le stringhe vengono trattate come primitive nonostante siano oggetti.
                                  // in questo caso non ho creato due stringhe Pippo, ma la VM crea la prima stringa Pippo, e successivamente
                                 // quando vede che vogliamo riutilizzare un'altra stringa che contiene "Pippo",  riutilizza quella già creata
                                // ogni variabile con valore "Pippo" punterà allo stesso indirizzo.

        //Per questo motivo, in java le stringhe sono immutabili perchè altrimenti non sarebbe possibile che più reference puntassero allo
        //stesso indirizzo di una stringa

        s1 = "Pluto"; //in questo caso, non sto modificando l'indirizzo di Pippo, ma la stringa a cui s1 punta.
        //quindi s1 non punta più alla stringa Pippo all'indirizzo x, ma punta alla stringa Pluto all'indirizzo y.
        //le altre reference che puntavano a Pippo restano invariate e continueranno a puntare a quella stringa.

        //anche nel caso in cui avessimo concatenato le stringhe, si sarebbe creata una nuova stringa frutto di quella concatenazione a cui
        //quella reference avrebbe puntato.

        s1 = " pluto ";
        s1.trim(); //trim è un metodo che rimuove gli spazi all'inizio e alla fine;
        System.out.println("s1 = pluto; s1.trim(): " + s1.length());

        //stampa 7 perchè .trim rimuove sì gli spazi, creerà una nuova stringa ma se non sovrascriviamo
        // s1 col .trim non modificherà la stringa perchè le stringhe sono immutabili. Devo quindi usare un'altra variabile

        s2 = s1.trim();
        System.out.println("s2 = s2.trim(): " + s2.length()); //stampa 5;
        s1 = s1.trim();
        System.out.println("s1 = s1.trim(): " + s1.length()); //stampa 5 anche questa, perchè viene direttamente sovrascritta.

        String st1 = "Pippo";
        String st2 = new String("Pippo");
        System.out.println(st1==st2); //in questo caso stamperà false.

        Prodotto prd1 = new Prodotto("Bicicletta", 100);
        Prodotto prd2 = new Prodotto("Bicicletta", 100);
        System.out.println(p1==p2); //stampa false perchè paragona i due indirizzi degli oggetti, non il contenuto;



        //-------------------------------------------------------------------------------------------------------------

        //Iterable > Collection > List > ArrayList, LinkedList;
        //Arraylist e LinkedList implementano List, che implementa collection che implementa iterable (che è la collection "madre");
        //Sarebbe buona cosa utilizzare la cosa più generale possibile, tuttavia dipende dai metodi che queste interfacce/classi contengono:
        //Iterable ad esempio ha come operazioni solamente capire se c'è un elemento successivo e mostrarlo;
        //In collection oltre a questo si aggiungono anche .add, .remove, ecc ma manca .get, quindi non c'è ordinamento.
        //Da list in poi c'è anche il .get, perciò possiamo prendere dall'arrayList un elemento in un punto (i) dell'array, cosa che prima non potevamo fare.

        //è importante quindi essere più generali possibile ma sempre in base a cosa dobbiamo fare con quel determinato elemento (in questo caso un arraylist)
        //o con quel determinato metodo

        List<String> result = findStartingWithS(List.of("casa", "cipolla", "scopa", "Scuola", "lombrico", "suola", "Sium"));

        System.out.println(result);
    }


    public static List<String> findStartingWithS(Iterable<String> stringhe) { //uso iterable perchè dovrò semplicemente scorrere la lista e in caso tirare fuori un elemento);

        List<String> paroleRitorno = new ArrayList<>();
        for(String parola : stringhe) {
            if(parola.charAt(0) == 's' || parola.charAt(0) == 'S') {
                paroleRitorno.add(parola);
            }
        }
        return paroleRitorno;
    }

}
