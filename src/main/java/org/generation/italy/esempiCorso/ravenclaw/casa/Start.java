package org.generation.italy.esempiCorso.ravenclaw.casa;

import java.util.List;

public class Start {
    public static void main(String[] args) {

        Casa c1 = new Villa(102, 3, true);
        Casa c2 = new Villa(1000, 12, false);
        Casa c3 = new Appartamento(92, 4, 10);
        Casa c4 = new Appartamento(32, 1, 3);

        List<Casa> ville = List.of(c1,c2);
        List<Casa> appartamenti = List.of(c3,c4);

        Archivio archivio = new Archivio(ville, appartamenti);

        System.out.println(archivio.mediaCosti(100));

    }
}
