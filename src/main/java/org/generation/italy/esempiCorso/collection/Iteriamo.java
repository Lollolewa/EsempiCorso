package org.generation.italy.esempiCorso.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Iteriamo {
    public static void main(String[] args) {
        //voglio fare una lista della spesa

        List<Prodotto> prodotti = new ArrayList<>();


        //aggiungere profotti
        prodotti.add (new Prodotto("Pane",3));
        prodotti.add(new Prodotto("Carne", 3));
        prodotti.add(new Prodotto("palo", 3));

        System.out.println(prodotti.size());

        Prodotto.acaso();

        int costotot = 0;
        for (Prodotto p : prodotti){
            System.out.println(p.descrizione);
            costotot += p.costo;
        }
        System.out.println(costotot);

        List<Prodotto> listLint = new LinkedList<>(); //utile quando vogliamo aggiungere velocemente elementi in coda o in testa -- usata molto poco
        listLint.add(new Prodotto("Pane",1)); //ogni argomento che aggiungiamo a linked list viene chiamato nodo - Il prodotto viene wrappato all interno di un altro oggetto che avra il prodotto e il riferimento al prodotto precedente e al successivo, come una catena.






    }
}
