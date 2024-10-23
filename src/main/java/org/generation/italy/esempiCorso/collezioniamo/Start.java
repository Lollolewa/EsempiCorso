package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {

    public static void main (String[] args){
        //collezioni -> insieme di elementi
        //array, struttura dati che è ordinata, contiene primitivi, dimenisioni fissa
        String[] nomi = new String[10];
        nomi[0] = "Pino";
        // interfaccia Collection, contiene al suo interno metodi di utilità per lavorare sulle collezioni

        //List
        //insieme di elementi ordinati, hanno una dimensione che varia in automatico
        //Iterable rappresenta una sequenza di oggetti -> Hai un porssimo elemento? Dammelo. Da non usare con le liste perchè non ha i metodi necessari Iterable si usa per ciclare
        //Collection invece serve a inserire e togliere oggetti, per ciclare possiamo anche utilizzare il for Each,
        //List p una Collection con il senso dell'ordinamento
        List<String> nomiClasse = new ArrayList<String>();
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        List<Integer> numeri = new ArrayList<>();

        //List<String> names = new ArrayList<>(List.of("Pino"));

        //List<String> names = List.of("Pino");
        //miClasse.remove = ("Lina");
        //nomiClasse.remove(1);
        //System.out.println(nomiClasse);

        String lina = nomiClasse.get(1);
        System.out.println(nomiClasse.get(1));
        System.out.println(lina);

        for(int i = 0; i < nomiClasse.size(); i++){
            System.out.println(nomiClasse.get(i));
        }
        //questo è for each
        //s -> singolo elemento che sto scorrendo
        for(String s : nomiClasse){ //collezione
            System.out.println(s);
        }

        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto("pane", 1));
        //il prodotto viene wrappato dentro un altro oggetto
        //il nuovo oggetto conterrà il prodotto, più 2 reference, una al prodotto precende e una al prodotto successivo
        //protdotto1 <-> prodotto 2 <-> prodotto3
        //prodotto1[null, prodotto1, rProdotto2]
        //prodotto2[rProdotto1, prodotto 2, rProdotto3]
        //prodotto3[rProdotto2, prodotto3, null]




        // set
        // set è sempre un insieme di elementi però non è ordinato e non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);

        Prodotto p1 = new Prodotto("pane", 1);
        Prodotto p2 = new Prodotto("pane", 1);

        Set<Prodotto> prodotti = new HashSet<>();
        prodotti.add(new Prodotto("pane", 1));
        prodotti.add(new Prodotto("pane", 1));
        System.out.println(prodotti.size());
        //nonostante i due oggetti abbiano lo stesso contenuto, ne definisce comunque 2 perchè non è correlato se per noi sono uguali lo sono per java.
       // boolean r = p1.equals(p2); //equals è ereditato da object, si comporta come ==
       // System.out.println(r);//due oggetti uguali devono avere per forza lo stesso HashCode e cioè dare true,
        //System.out.println(p1.equals(p2));
        //System.out.println(p1.hashCode() == p2.hashCode());
       // System.out.println(p1.hashCode());
       // System.out.println(p2.hashCode());

        String s1 = "pippo";
        String s2 = "pippo";
        //System.out.println(s1==s2); //ovviamente stampa o true o false il paragone ci da una booleana, True

        //quando si crea una stringa non si mette il new perchè la VM cerca di risparmiare memoria, vuole una sola stringa puntata da tutte le references necessarie
        Prodotto p4 = new Prodotto("bicicletta", 100);
        Prodotto p5 = new Prodotto("bicicletta", 100);
        //System.out.println(p1 == p2);  //le stringe in java sono immutabili, per questo gli oggetti non saranno mai uguali mentre le delle variabili con la stessa Stringa puntano allo stesso indirizzo,
        s1 = " pluto "; //non cambio la variabile, ma dove sta puntando
        String s3 = s1.trim();
        s1.trim(); //trim è un metodo che rimuove gli spazi all'inizio e alla fine
       // System.out.println(s1.length()); //anche se trim dovrebbe togliere gli spazi, del system out ci stamperà 7,
        //System.out.println(s3.length());//questo ci stamperà 5 questo ci fa capire che le Stringhe in Java non posso essere in nessun modo modificate
        Set<String> saluti = new HashSet<>();
        saluti.add("ciao");
        saluti.add("hello");
        saluti.add("ciao");

        for(String s : saluti){
            if(s.equals("hello")){
            }
        }

        List<String> result = findStartingWithS(List.of("casa", "cipolla", "scopa", "lombrico"));
        //System.out.println(result);
    }
    public static List<String> findStartingWithS(List<String> stringhe){
        //posso sempre castare dalla superclasse alla sottoclasse, ma non viceversa
        List<String> paroleRitorno= new ArrayList<>();
        for(String parola : stringhe){
            if (parola.charAt(0) == 's') {
                paroleRitorno.add(parola);

            }


        }
        return paroleRitorno;

    }
}
