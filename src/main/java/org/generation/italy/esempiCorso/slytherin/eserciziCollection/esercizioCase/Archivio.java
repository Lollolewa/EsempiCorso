package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCase;

import java.util.ArrayList;

public class Archivio {
    private ArrayList<Villa> ville;
    private ArrayList<Appartamento> appartamenti;

    public Archivio() {
        ville = new ArrayList<>();
        appartamenti = new ArrayList<>();
    }

    public void aggiungiVilla(Villa villa) {
        ville.add(villa);
    }

    public void aggiungiAppartamento(Appartamento appartamento) {
        appartamenti.add(appartamento);
    }

    // Metodo per calcolare la media dei costi delle case con superficie maggiore di n
    public double mediaCosti(double n) {
        double sommaCosti = 0;
        int count = 0;

        for (Villa villa : ville) {
            if (villa.superficie > n) {
                sommaCosti += villa.costoCasa();
                count++;
            }
        }

        for (Appartamento appartamento : appartamenti) {
            if (appartamento.superficie > n) {
                sommaCosti += appartamento.costoCasa();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return sommaCosti / count;
    }
}