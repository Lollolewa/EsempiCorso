package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {
    //voglio fare una lista della spesa

    public static void main(String[] args) {
        List<Prodotto> prod = new ArrayList<>();
        prod.add(new Prodotto("farina", 1));
        Prodotto p = new Prodotto("latte",5);
        p.aCaso();
    }
}
