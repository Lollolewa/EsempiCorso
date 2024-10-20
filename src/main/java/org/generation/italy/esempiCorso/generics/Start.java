package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List names = new ArrayList<>(); // list of names
        names.add("Pippo"); // aggiunta una stringa
        names.add(Integer.valueOf(25)); // aggiunta una integer
        names.add(5); // aggiunta una integer
        doSomethingWithList(names); // do something with names

        List<String> parole = new ArrayList<>();
        parole.add("Ciao"); // aggiunta una stringa
        // parole.add(Integer.valueOf(2)); // Non è possibile aggiungere un Integer alla lista di parole
        // parole.get(0);  Non è possibile eseguire il metodo get() su un Integer. C'è un'eccezione ClassCastException.
        String y = parole.get(0); //
        doSomethingWithList(parole);
        Pair<String, Integer> pair = new Pair<>("Ciao", 25);
        Pair<Integer, String> pair2 = new Pair<>(25, "Ciao");
        System.out.println(pair.equals(pair2));
        System.out.println(pair.getFirst());
        System.out.println(pair2.getFirst());
    }
    public static void doSomethingWithList(List x){
        x.add("Pluto"); //
        Object z = x.get(0);
        System.out.println(z);
        String s = (String) x.get(0);
        x.add(new StringBuilder());
    }
    public static void doSomethingWithGenericList(List<String> x){
        x.add("Pluto");
        String s = x.get(0);
        System.out.println(s);
        // x.add(Integer.valueOf(2)); // Non è possibile aggiungere un Integer alla lista di parole
    }
}
// Generics sono state aggiunte nel Java 5 per consentire a tipi generici.
// Le classi generiche permettono di creare tipi parametrici che possono contenere elementi di diversi tipi.
// Sono strutture dati.
// Type erasure è un processo automatico che viene eseguito durante la compilazione del codice Java, che trasforma i tipi generici in tipi non generici.