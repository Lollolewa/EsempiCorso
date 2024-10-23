package org.generation.italy.esempiCorso.griffindor.eserciziCollection.casa;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    protected List<Villa> ville;
    protected List<Appartamento> appartamenti;

    public Archivio() {
    ville = new ArrayList<>();
    appartamenti = new ArrayList<>();
    }
    public double mediaCosti(int superficieMinima) {
        double sommaCosti = 0;
        int conta= 0;

        for (Villa villa : ville) {
            if (villa.superficie >= superficieMinima) {
                sommaCosti += villa.costoCasa();
                conta++;
            }
        }
        for (Appartamento appartamento : appartamenti) {
            if (appartamento.superficie >= superficieMinima) {
                sommaCosti += appartamento.costoCasa();
                conta++;
            }
        }
        return sommaCosti / (double) conta;
    }
    public void aggiungiVilla(Villa villa) {
        ville.add(villa);
    }
    public void aggiungiAppartamento(Appartamento appartamento) {
        appartamenti.add(appartamento);
    }
}

