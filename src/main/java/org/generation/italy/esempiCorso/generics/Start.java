package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[] args) {
        //generics sono nuove, sono strutture dati nel 90% dei casi.
        List names = new ArrayList();
        names.add("Pippo");
        names.add(Integer.valueOf(4));
        names.add(4);
        doSomethingWithGenericList(names);

        List<String> words = new ArrayList<>();
        words.add("Topolino");
        String y = words.get(0);
        doSomethingWithGenericList(words);
        Pair<String, Integer> pair1 = new Pair<>("Rocket", 4);
        Pair<Integer, String> pair2 = new Pair<>(4, "Rocket");
        System.out.println(pair1.equals(pair2));
        System.out.println(pair1.getFirst());
        System.out.println(pair2.getFirst());
    }
    public static void doSomethingWithList(List x) {
        // x è una lista di qualsiasi tipo
        x.add("Ciccio");
        Object z = x.get(0);
        System.out.println(z);
        String s = (String) x.get(0);
    }
    public static void doSomethingWithGenericList(List<String> x){
        x.add("Rocket");
        String result = x.get(0);
        //x.add(new Integer(2)); questo non compila perché non è possibile aggiungere un Integer a una lista di String
    }
}