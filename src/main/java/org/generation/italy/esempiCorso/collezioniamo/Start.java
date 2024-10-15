package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {
    public static void main(String[] args){
        //collezioni -> insieme di elementi
        //array, struttura dati ordinata, contiene primitivi, dimensione fissa
        String[] nomi = new String[10];
        nomi[0] = "Pino";
        //interfaccia Collection, contiene al suo interno metodi di utilità per lavorare sulle collezioni

        //list
        //insieme di elementi ordinati, ha una dimensione variabile
        List<String> nomiClasse = new ArrayList<String>(); //polimorfismo
        //sinistra creo la variabile , a destra la incremento con la classe concreta
        //List è una Collection con il senso dell'ordinamento, consente random access
        //Collection<String> nomiClasse = new ArrayList<>(); // polimorismo super perdo i metodi di List
        //Iterable<String> nomiClasse = new ArrayList<>(); //top del polimorfismo ma perdo i metodi di Collection

        nomiClasse.add("Pino");
        nomiClasse.add("Lina");
        //posso aggiungere elementi senza limiti perchè non ho specificato la grandezza della lista

        //puoi rimuovere gli elementi sia in base al valore sia in base all'indice
        //nomiClasse.remove("lina");
       // nomiClasse.remove(1);

        String lina = nomiClasse.get(1); //

        for(int i=0; i<nomiClasse.size();i++){
            System.out.println(nomiClasse.get(i));
        }

        //for each, s -> singolo elemento che sto scorrento
        for(String pippo : nomiClasse){
            System.out.println(pippo);;
        }

        //------------------------------------------------

        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("Pane", 1));
        //il prodotto viene wrappato dentro un altro oggetto
        //il nuovo oggetto conterrà il prodotto, più 2 reference, una al prodotto precedente e una al prodotto successivo
        //prodotto1 <-> prodotto2 <-> prodotto3
        //prodotto1[null, prodotto1, rProdotto2]
        //prodotto2[rProdotto1, prodotto2, rProdotto3]
        //prodotto3[rProdotto2, prodotto3, null]

        //la linkedList è comoda nel momento in cui voglio aggiungere o rimuovere elementi in coda o in testa

        //---------------------------------------------
        //set -> insieme di elementi non ordinato (non puoi accere tramite indice) che non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(19);
        //stampa 2 oggetti perchè non ammette due duplicati


        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("pane",1));
        prodotti.add(new Prodotto("pane",1));
        System.out.println(prodotti.size());
        //stampa 2 perchè hai creato due prodotti, due oggetti diversi che puntano a due indirizzi diversi
        //se due oggetti hanno lo stesso contenuto informatico, il valore delle due variabili è identico, non è detto che siano lo stesso oggetto, SPOILER NON LO SONO

        String s1 = "pippo";
        String s2 = "pippo";
        //String s2 = new String("pippo"); SE METTO QUESTA DA COME RISULTATO FALSE

        System.out.println(s1==s2); //può stampare true o false
        //dovrebbe stampare false perchè sta paragonando due indirizzi, non i due oggetti,
        //stampa true perché non ho creato due stringhe, s2 non punta ad un nuovo oggetto ma ad s1
        //in java le stringhe sono immutabili perchè altrimenti non sarebbe possibile che più stringhe puntino alla stessa reference
        s1= s1 + "ciao"; //viene creata un altra stringa che combina s1 e ciao
        //ogni volta che concateni stringhe ne crei altre nuove
        s1= "pluto"; //non sto cambiando la stringa, sto cambiando il puntatore di s1
        s1 = " pluto ";
        String s3 = s1.trim(); //trim è un metodo che rimuove gli spazi all'inizio e alla fine
        System.out.println(s1.length()); //stampa 7 perchè .trim crea una nuova stringa
        System.out.println(s3.length()); //stampa 5
        s1=s1.trim();
        System.out.println(s1.length()); //stampa 5

        //quando si crea una stringa non si mette il new perchè la vm cerca di risparmiare memoria , vuole una sola stringa puntata da tutte le references necessarie

        Prodotto p1 = new Prodotto("bicicletta", 100);
        Prodotto p2 = new Prodotto("bicicletta", 100);
        System.out.println(p1==p2); //questo stampa false perchè stai paragonando le referenc

        List<String> result = findStartingWithS(List.of("casa","cipolla","scopa","lombrico"));
    }

    //Ignorance is Bliss->
    public static List<String> findStartingWithS(Iterable<String> stringhe){
        // posso sempre castare dalla superclasse alla sottoclasse, non vicevera
        //passo qualsiasi tipo di iterable mi ritorna una lista
        List<String> paroleRitorno = new ArrayList<>(); //polimorfismo ever win
        for(String parola : stringhe){
            if(parola.charAt(0) == 's'){
                paroleRitorno.add(parola);
            }
        }
        return paroleRitorno; //non funziona se fai tornare un ArrayList, funziona se torna una List
        //return (ArrayList<String>) paroleRitorno; funziona anche se deve tornare un ArrayList
    }
}
