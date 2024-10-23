package org.generation.italy.esempiCorso.griffindor.eserciziCollection.rubrica;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contatto> contatti = new ArrayList<>();

        contatti.add(new Contatto("Marco", "Falconetti", "3401459332"));
        contatti.add(new Contatto("Luca", "Falconetti", "3425510010"));
        contatti.add(new Contatto("Francesco", "Spezzano", "3466523003"));
        contatti.add(new Contatto("Stefano", "Puro", "342643210"));

        Rubrica rubrica = new Rubrica(contatti);

        System.out.println("Rubrica iniziale:");
        System.out.println(rubrica);

        System.out.println("Cerca Giulio Falconetti:");
        System.out.println(rubrica.cerca("Giulio", "Falconetti"));
        System.out.println("Cerca Marco Falconetti:");
        System.out.println(rubrica.cerca("Marco", "Falconetti"));

    }
}
