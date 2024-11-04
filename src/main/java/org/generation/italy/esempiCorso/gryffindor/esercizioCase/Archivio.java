package org.generation.italy.esempiCorso.gryffindor.esercizioCase;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    protected List<Villa> villas;
    protected List<Appartamento> appartamentos;

    public Archivio(List<Villa> villas, List<Appartamento> appartamentos){
        this.villas=villas;
        this.appartamentos=appartamentos;
    }
    public double mediaCosti(int superficieMinima){
        double sommaCosti=0;
        int counter=0;
        for(Villa villa : villas){
            sommaCosti+=villa.costoCasa();
            counter++;
        }
        for(Appartamento appartamento : appartamentos){
            sommaCosti+=appartamento.costoCasa();
            counter++;
        }
        return sommaCosti/(double) counter;
    }
}
