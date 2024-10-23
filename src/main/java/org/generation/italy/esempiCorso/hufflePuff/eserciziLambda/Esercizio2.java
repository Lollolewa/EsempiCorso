package org.generation.italy.esempiCorso.hufflePuff.eserciziLambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio2 {
    public static void main(String[] args) {
        List<String> word = Arrays.asList("Orologio", "Sigaretta", "Accendino", "Albero", "Asciugamano");
        List<String> wordsWithA = word.stream().filter(w -> w.startsWith("A")).toList();
        System.out.println(wordsWithA);
    }
}
