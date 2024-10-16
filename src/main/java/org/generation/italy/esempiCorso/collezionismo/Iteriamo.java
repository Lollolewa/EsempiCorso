package org.generation.italy.esempiCorso.collezionismo;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {
    public static void main(String[] args) {
        //voglio fare una lista della spesa,

        List<Prodotto> prodotti = new ArrayList<Prodotto>();

        //aggiungere un prodotto

        prodotti.add(new Prodotto("Farina", 1));
        prodotti.add(new Prodotto("Pomodoro", 1));
        prodotti.add(new Prodotto("Mozzarella", 1));
        Prodotto prodotto = prodotti.get(0);
        int costoTotale = 0;
        for (Prodotto p : prodotti){
            costoTotale += p.costo;
            System.out.println(p.nome + " " + p.costo);
        }

       // Prodotto prodotto = new Prodotto("Ciao",5);
        //prodotto.aCaso();
    }
}