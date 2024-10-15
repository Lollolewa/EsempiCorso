package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        String[] nomiClasseMarcio = new String[10];

        // interfaccia Collection; contiene metodi di utilità per lavorare sulle collezioni
        // list: insieme di elementi ordinati che hanno una dimensione ordinata

        List<String> nomiClasse = new ArrayList<>();
        nomiClasse.add("Pino");
        nomiClasse.add("Lina");

        // nomiClasse.remove(1);
        // nomiClasse.remove("Lina");

        String lina = nomiClasse.get(1);

        for (int i = 0; i < nomiClasse.size(); i ++) {
            System.out.println(nomiClasse.get(i));
        }

        // for each:
        // sulla sinistra ho il singolo elemento che sto scorrendo || sulla destra ho il nome della mia collezione
        for (String s : nomiClasse) { // per ogni s contenuta in nomiClasse
            System.out.println(s);  // printami s
        }

        List<String> listLink = new LinkedList<>();
    }
}
