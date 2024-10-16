package org.generation.italy.esempiCorso.opera;

import org.generation.italy.esempiCorso.collezionismo.Prodotto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OperaDarte> opere = new ArrayList<>(); // Creazione di un ArrayList di opere d'arte
        Collezione collezione = new Collezione("Arte Rinascimentale", "Firenze", opere);

        // Aggiunta di opere alla collezione
        collezione.aggiungiOperaDarte(new Quadro("Gioconda", "Leonardo", 18, 15));
        collezione.aggiungiOperaDarte(new Scultura("David", "Michelangelo", 5, 2, 1));

        // Stampa la collezione
        collezione.stampCollezione();
    }
}

