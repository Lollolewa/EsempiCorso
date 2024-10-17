package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;

public class Start { // classi che si specializzano a lavorare con altri classi, esempio ArrayList
                     // 90% delle volte le generics sono strutture dati
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Pippo");
        //names.add(Integer.valueOf(4));
        names.add(4); // uguale a scrivere la linea sopra, viene automaticamente castato ad integer
                      // perchè per essere accettato da un'ArrayList deve essere in oggetto
        doSomethingWithList(names);

        List<String> words = new ArrayList<>();
        //words.add(Integer.valueOf(2));
        String y = words.getFirst();
        doSomethingWithList(words);

        Pair<String, Integer> pair1 = new Pair<>("rocket", 5);
        Pair<Integer, String> pair2 = new Pair<>(5, "rocket");
        System.out.println(pair1.equals(pair2));
    }
    public static void doSomethingWithList (List x) {
        x.add("Ciccio");
        Object z = x.getFirst();
        System.out.println(z);
        String s = (String) x.getFirst();
    }
    public static void doSomethingWithGenericList (List<String> x) {
        x.add("Pippo");
        String s = x.getFirst();
        //x.add(Integer.valueOf(2));
    }//banana
}
