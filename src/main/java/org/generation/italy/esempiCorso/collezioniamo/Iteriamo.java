package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {
    public static void main(String[] args) {
        // voglio fare una lista della spesa
        List<Prodotto> prodotti = new ArrayList<>();

        // aggiungere dei prodotti
        prodotti.add(new Prodotto("farina", 8));
        prodotti.add(new Prodotto("pomodoro", 5));
        prodotti.add(new Prodotto("mozzarella", 8));
        prodotti.add(new Prodotto("origano", 3));

        System.out.println(prodotti.size());

        Prodotto prodotto = prodotti.get(0);

        int costoTotale = 0;
        for (Prodotto p : prodotti) {
            costoTotale += prodotto.costo;
        }
    }
}
