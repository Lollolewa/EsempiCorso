package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {
    public static void main (String[] args){
        //voglio fare una lista della spesa

        List<Prodotto> prodotti = new ArrayList<>();

        //aggiungere dei prodotti
        prodotti.add(new Prodotto("farina", 1));
        prodotti.add(new Prodotto("pomodoro", 2));
        prodotti.add(new Prodotto("mozzarella", 1));

        System.out.println(prodotti.size());

        Prodotto prodotto = prodotti.get(0); //prendiamo il prodotto nella sua posizione
        //prodotto.aCaso();

        int costoTotale = 0;
        for(Prodotto p : prodotti){
            costoTotale += p.costo;
            System.out.println(p.costo);
        }
        System.out.println(costoTotale);


    }
}
