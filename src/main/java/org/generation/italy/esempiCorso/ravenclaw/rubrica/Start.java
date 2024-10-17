package org.generation.italy.esempiCorso.ravenclaw.rubrica;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        r.addContatto("narco","rossi","34235233");

        System.out.println(r.toString());
        r.rimuoviContatto("narco","rossi");
    }
}
