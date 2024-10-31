package org.generation.italy.esempiCorso.inheritance.hufflePuff.eserciziCollection;

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

    public double mediaCosti(double superficieMinima) {
        double sommaCosti = 0;
        int count = 0;

        for (Villa villa : ville) {
            if (villa.getSuperficie() > superficieMinima) {
                sommaCosti += villa.costoCasa();
                count++;
            }
        }

        for (Appartamento appartamento : appartamenti) {
            if (appartamento.getSuperficie() > superficieMinima) {
                sommaCosti += appartamento.costoCasa();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return sommaCosti / count;  // Media dei costi
    }
}
