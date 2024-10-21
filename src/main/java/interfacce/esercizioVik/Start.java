package interfacce.esercizioVik;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        OperaDArte q1 = new Quadro("Guernica", "Picasso", 1938, 30000, true);
        OperaDArte q2 = new Quadro("Mario", "Rossi", 1980, 80000, false);
        OperaDArte q3 = new Quadro("Luigi", "Verdi", 1990, 75000, false);

        GestioneQuadriImpl x = new GestioneQuadriImpl();

        x.add(q1);
        x.add(q2);
        x.add(q3);

        System.out.println(x.searchForName("Mario").isPresent() ? x.searchForName("Mario") : "quadro non presente");
        System.out.println(x.searchForName("Mario").isPresent() ? x.searchForName("Mario") : "quadro non presente");
        System.out.println(x.searchForName("aga").isPresent() ? x.searchForName("aga") : "quadro non presente");
    }
}

/*Creare un'interfaccia GestioneQuadri
* dovrà avere i seguenti metodi:
* aggiungi
* rimuovi
* cercaPerNome
* cercaPerAnno
*
* classe OperaDArte(astratta): nome, anno, autore, costo
*
* classe Quadro: nome, anno, autore, costo , boolean cornice(extends OperaDArte)
*
* classe Start: lista di OperaDArte con la possibilità di usare cerca aggiungi rimuovi
* */