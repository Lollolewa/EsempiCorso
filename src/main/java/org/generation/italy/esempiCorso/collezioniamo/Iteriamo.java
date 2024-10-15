package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {
    public static void main(String[] args) {
        // Facciamo una lista
        List<Prodotto> prodotti = new ArrayList<>();

        // Aggiungiamo Prodotti
        prodotti.add(new Prodotto("Farina", 1));
        prodotti.add(new Prodotto("Pomodoro", 2));
        prodotti.add(new Prodotto("Mozzarella", 3));

        System.out.println("Numero di prodotti nella lista: " + prodotti.size()); // Vedere lunghezza della lista

        // Calcolo del costo totale
        int costoTotale = 0;

        for (Prodotto p : prodotti) {
            costoTotale += p.getCosto(); // Usa il metodo getCosto per ottenere il costo
            System.out.println(p); // Stampa dettagli del prodotto
        }

        System.out.println("Costo totale: " + costoTotale);
    }
}
