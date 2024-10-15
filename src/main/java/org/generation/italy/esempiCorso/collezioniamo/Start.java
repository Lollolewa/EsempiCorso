package org.generation.italy.esempiCorso.collezioniamo;

import java.util.*;

public class Start {
    public static void main(String[] args) {
        String[] nomiClasseMarcio = new String[10];

        // interfaccia Collection; contiene metodi di utilità per lavorare sulle collezioni
        // list: insieme di elementi ordinati che hanno una dimensione ordinata

        //Iterable rappresenta una sequenza di oggetti -> Hai un prossimo elemento? Dammelo. Da non usare con le liste perchè non ha i metodi necessari

        // List è una Collection con il senso dell'ordinamento
        List<String> nomiClasse = new ArrayList<>(); // polimorfismo❤️
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        // nomiClasse.remove(1);
        // nomiClasse.remove("Lina");

        String lina = nomiClasse.get(1);

        for (int i = 0; i < nomiClasse.size(); i ++) {
            System.out.println(nomiClasse.get(i));
        }

        // for each:
        // sulla sinistra ho il singolo elemento che sto scorrendo || sulla destra ho il nome della mia collezione
        for(String s : nomiClasse){ // per ogni s contenuta in nomiClasse
            System.out.println(s);  // printami s
        }

        //--------------------------

        //LinkedList, più performante nell'inserimento e rimozione
        List<Prodotto> listLink = new LinkedList<>();
        listLink.add(new Prodotto( "pane",1)) ;
        // il prodotto viene rappato dentro un altro oggetto
        // il nuovo oggetto conterrà il prodotto, più 2 reference, una al prodotto precedente e una al prodotto successivo
        // prodotto1 <-> prodotto2 <→> prodotto3
        // prodotto1[null, prodottol, rProdotto2]
        // prodotto2[rProdotto1, prodotto2, rProdotto3]
        // prodotto3[rProdotto2, prodotto3, null]

        //----------------------------

        //SET -> insieme di elementi non ordinati e non ammette duplicati

        Set<Integer> numbers = new HashSet<>();
        numbers.add(19);
        numbers.add(20);
        numbers.add(21);
        numbers.add(19);

        List<String> result = findStartingWithS(List.of("casa", "cipolla", "scopa", "lombrico", "salice"));
        System.out.println(result);

    }

    // Ignorance is Bliss (Matrix) -> siamo felici quando lavoriamo con cose generali
    public static List<String> findStartingWithS(Iterable<String> stringhe){
        // posso sempre castare dalla superclasse alla sottoclasse, ma non viceversa
        List<String> paroleRitorno = new ArrayList<>(); // il polimorfismo è nostro amico
        for(String parola : stringhe){
            if(parola.charAt(0) == 's'){
                paroleRitorno.add(parola);
            }
        }
        return paroleRitorno;
    }
}