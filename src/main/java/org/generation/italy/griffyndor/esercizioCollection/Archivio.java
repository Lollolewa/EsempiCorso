package org.generation.italy.griffyndor.esercizioCollection;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    protected List<Villa> ville = new ArrayList<>();
    protected List<Appartamento> appartamenti = new ArrayList<>();

    public Archivio(List<Villa> ville, List<Appartamento> appartamenti) {
        this.ville = ville;
        this.appartamenti = appartamenti;
    }
    public double mediaCosti(int superficieMinima){
        double sommaCosti = 0;
        int conta = 0;
        for(Villa villa : ville){
            if(villa.superficie >= superficieMinima){
                sommaCosti += villa.costoCasa();
                conta++;
            }
            return 0;
        }

    for(Appartamento appartamento : appartamenti) {
        if (appartamento.superficie >= superficieMinima) {
            sommaCosti += appartamento.costoCasa();
            conta++;
        }
    }
        return sommaCosti / (double)conta;
    }

}
