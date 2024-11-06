package org.generation.italy.esempiCorso.gryffindor.esercizioCase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Casa c1 = new Appartamento(100,4,5);
        Casa c2 = new Appartamento(80,3,2);
        Casa c3 = new Villa(170,7,false);
        Casa c4 = new Villa(230,10,true);

        List<Villa> villas = new ArrayList<>();
        List<Appartamento> appartamentos = new ArrayList<>();

        villas.add((Villa) c3);
        villas.add((Villa) c4);
        appartamentos.add((Appartamento) c1);
        appartamentos.add((Appartamento) c2);
        //Archivio archivio = new Archivio(villas,appartamentos){
            
        //}
    }
}
