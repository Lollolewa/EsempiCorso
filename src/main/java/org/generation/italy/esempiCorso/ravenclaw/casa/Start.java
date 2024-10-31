package org.generation.italy.esempiCorso.ravenclaw.casa;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Casa c1 = new Villa(10, 10, true);
        Casa c2 = new Villa(100, 10, false);
        Casa c3 = new Appartamento(92, 4, 5);
        Casa c4 = new Appartamento(32, 1, 3);

        List<Casa> ville = List.of(c1, c2);
        List<Casa> appartamenti = List.of(c3, c4);

        Archivio caccola = new Archivio(ville, appartamenti);
        System.out.println(caccola.mediaCosti(99));
    }
}