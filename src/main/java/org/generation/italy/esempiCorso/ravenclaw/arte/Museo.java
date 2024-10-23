package org.generation.italy.esempiCorso.ravenclaw.arte;

import java.util.ArrayList;
import java.util.List;

public class Museo {
    public static void main(String[] args) {

        OperaDArte q1 = new Quadro("Gigro", "Bobson", 90, 45);
        OperaDArte q2 = new Quadro("Gigro", "Bobson", 90, 45);

        OperaDArte s1 = new Scultura("Slaco", "Rocko", 190,90, 40);

        List<OperaDArte> opere = new ArrayList<>();
        opere.add(q1);
        opere.add(s1);

        Collezione mostra = new Collezione("Mostra", "Pirri",opere);

        System.out.println(q1.printIngombro());


        mostra.aggiungiOpere(new Quadro("gini", "rocket", 33, 32));


        System.out.println(q1.confrontaOpere(q2));

    }
}
