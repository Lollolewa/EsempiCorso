package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.museo;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<OperaDArte> opere = new ArrayList<>();

        Quadro quadro = new Quadro("Mona Lisa", "Leonardo da Vinci", 5, 5);
        Scultura scultura = new Scultura("David", "Michelangelo", 20, 10, 10);

        Collezione collezione = new Collezione(opere, "Galleria degli Uffizi", "Rinascimento");
        collezione.inserisciOpera(quadro);
        collezione.inserisciOpera(scultura);

        collezione.stampaCollezione();
    }
}