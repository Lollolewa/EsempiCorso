package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Iteriamo {
    public static void main(String[] args){
        //voglio fare una lista della spesa
        List<Prodotto> prodotti = new ArrayList<>();

        //aggiungere prodotti
        prodotti.add(new Prodotto("farina", 1));
        prodotti.add(new Prodotto("pomodoro", 2));
        prodotti.add(new Prodotto("mozzarella",1));

        System.out.println(prodotti.size()); //vedere la lunghezza della lista
        Prodotto prodotto = prodotti.get(0); // con get prendiamo il prodotto alla posizione 0
        for(Prodotto p : prodotti){
            System.out.println(p);
        }
        // -------------------------------

        List<String> link = new LinkedList<>();
        // prodotto1 collegato al prodotto 2 che e collegata al prodotto 3
        // il prodotto viene wrappato dentro un altro oggetto
        // il nuovo oggetto conterra il prodotto piu 2 reference, 1 al prodotto precedente e 1 a quello seguente
        // prodotto 1 wrappato in un oggetto, ma avra null, prodotto1, rprodotto2.
        // prodotto 2 rprodotto1, rprodotto2, rprodotto3
        // comoda quando vogliamo aggiungere cose in coda o in testa
        // arraylist non vogliono classi primitive

    }
}
