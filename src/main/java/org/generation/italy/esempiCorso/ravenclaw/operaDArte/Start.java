package org.generation.italy.esempiCorso.ravenclaw.operaDArte;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main (String[] args){
        OperaDArte Donatello = new Quadro("laMadonna", "Gesù", 50,80);
        OperaDArte Archimede = new Quadro("Dio", "Gesù", 50, 80);
        OperaDArte Ua = new Scultura("aaaaa", "madonna", 50,80,60 );
        OperaDArte Ue = new Scultura("aaaa", "madonna", 50,50,60 );

        Collezione collezione = new Collezione("ROma", "ROma", new ArrayList<OperaDArte>());
        collezione.inserisciOpere(Archimede);
        collezione.inserisciOpere(Donatello);
        collezione.stampaCollezione();

    }
}
