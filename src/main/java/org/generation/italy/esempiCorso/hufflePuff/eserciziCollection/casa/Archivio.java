package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.casa;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    private List<Villa> ville = new ArrayList<>();
    private List<Appartamento> appartamenti = new ArrayList<>();

    public Archivio() {
        ville = new ArrayList<>();
        appartamenti = new ArrayList<>();
    }

    public double mediaCosti(int supBound){
        int sum = 0;
        int count = 0;
        for (Villa villa : ville) {
            if (villa.superficie > supBound) {
                sum += villa.costoCasa();
                count++;
            }
        }
        for (Appartamento appartamento : appartamenti) {
            if (appartamento.superficie > supBound) {
                sum += appartamento.costoCasa();
                count++;
            }
        }
        return count > 0 ?  sum / (double) count : 0;
    }

    public List<Villa> getVille() {
        return ville;
    }

    public List<Appartamento> getAppartamenti() {
        return appartamenti;
    }
}