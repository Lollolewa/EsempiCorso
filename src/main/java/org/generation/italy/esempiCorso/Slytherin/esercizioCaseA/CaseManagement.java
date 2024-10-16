package org.generation.italy.esempiCorso.Slytherin.esercizioCaseA;

import java.util.ArrayList;
import java.util.List;

public class CaseManagement {
    public static void main(String[] args) {

        // appartamenti.add(new Appartamento(100, 2, 2); questo modo semplificato per istanziare e aggiungere
        // in una sola riga
        Appartamento a1 = new Appartamento(200, 2, 2);
        Appartamento a2 = new Appartamento(100, 10, 3);
        Appartamento a3 = new Appartamento(101, 4, 4);

        Villa v1 = new Villa(100, 4, true);
        Villa v2 = new Villa(50, 10, false );
        Villa v3 = new Villa(101, 3, true);

        List<Appartamento> appartamenti = new ArrayList<>();
        List<Villa> ville = new ArrayList<>();

        appartamenti.add(a1);
        appartamenti.add(a2);
        appartamenti.add(a3);

        ville.add(v1);
        ville.add(v2);
        ville.add(v3);

        // creato una nuova istanza di Archivio passando la lista di ville e di appartamenti come richiesto
        // nel costruttore di Archivio
        Archivio archivio = new Archivio(ville, appartamenti);

        // richiamo mediaCosti metodo di Archivio passando come parametro la superficie minima scelta
        System.out.println("La media dei costi delle case è: " + archivio.mediaCosti(100));

    }
}
