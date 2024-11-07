package org.example;
import org.generation.italy.esempiCorso.eserciziStre.Persona;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Esercizio
//Immagina di avere una lista di oggetti che rappresentano persone. Ogni persona ha un nome e una età. Vogliamo:
//
//Filtrare le persone che hanno più di 18 anni.
//Ordinare le persone per età in ordine decrescente.
//Creare una lista di nomi delle persone adulte, in cui ogni nome sia in maiuscolo.
//Calcolare la somma delle età delle persone adulte.
//Stampare i nomi delle persone adulte e la somma delle loro età.
//Passaggi:
//Creare la classe Persona con attributi nome e età.
//Creare la lista di oggetti Persona.
//Usare lo Stream per eseguire le operazioni richieste (filtrare, ordinare, trasformare, e raccogliere).
//Usare Lambda Expressions per la logica di filtraggio, trasformazione e ordinamento.
//Usare Method References per alcune operazioni (ad esempio, per stampare i nomi).


public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Gabriele",18);
        Persona persona2 = new Persona("Danilo",20);
        Persona persona3 = new Persona("Marco",24);
        List<Persona> listaPersona = Arrays.asList(persona1,persona2,persona3);

        List<String> personProva = listaPersona.stream().filter(p -> p.getAge()>=18).sorted(Comparator.comparing(Persona::getAge).reversed()).map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(personProva);
        int personCalcola = listaPersona.stream().filter(p -> p.getAge()>=18).mapToInt(p -> p.getAge()).sum();
        System.out.println(personCalcola);
        System.out.println("Nomi :" + personProva + "eta complessiva :" + personCalcola);

    }

}