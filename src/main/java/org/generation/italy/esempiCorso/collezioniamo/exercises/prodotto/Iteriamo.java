package org.generation.italy.esempiCorso.collezioniamo.exercises.prodotto;

import java.util.ArrayList;
import java.util.List;

public class Iteriamo {

    public static void main(String[] args) {
        //voglio fare una lista della spesa;

        List<Prodotto> prodotti = new ArrayList<>();

        //aggiungere dei prodotti

        prodotti.add(new Prodotto("Farina", 1));
        prodotti.add(new Prodotto("Pomodoro", 2));
        prodotti.add(new Prodotto("Mozzarella", 1));

        System.out.println(prodotti.size()); //vedere la lunghezza della lista (3)

        Prodotto prodotto = prodotti.get(0); //.get(index) ci andiamo a prendere il prodotto alla posizione 0;
        prodotto.descrizioneJavadoc(); //vai col cursore sul metodo ;)

        for (Prodotto p : prodotti) {
            System.out.println(p); //stampa solitamente in automatico il toString di p, ma in questo caso no perchè non abbiamo fatto l'override.
        }



    }
}
