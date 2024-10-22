package org.generation.italy.esempiCorso.library;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {

        Libreria libreria = new Libreria();
        libreria.addLibri("Predatore", "Cornwell", 2011);
        libreria.addLibri("Il nome della rosa", "Umberto Eco", 1945);
        libreria.addLibri("King", "Meghan March", 2019);
        libreria.addLibri("Il posto che cercavo", "Nicholas Sparks", 2011);
        libreria.addLibri("Io uccido", "Giorgio Faletti", 2001);
        libreria.getLibriDisponibili(true).get(0).setIsDisponibile(false);

        Scanner sc = new Scanner(System.in);
        String azione = "";
        System.out.println("Vuoi visualizzare l'elenco dei libri, ricercare un libro per titolo o autore, " +
                "prendere un libro in prestito o restituire un libro?");
        do {
            azione = sc.nextLine();

            switch (azione.toLowerCase(Locale.ROOT)) {
                case "visualizza":
                    System.out.println(libreria.visualizzaElenco());
                    System.out.println("Cosa vuoi fare adesso?");
                    break;
                case "ricerca libro":
                    System.out.println("Quale autore o titolo?");
                    String nomeAutore = sc.nextLine();
                    List<Libro> libriAutore = libreria.ricercaLibro(nomeAutore);
                    if(!libriAutore.isEmpty()){
                        System.out.println(libriAutore);
                    } else {
                        System.out.println("I libri per l'autore non sono disponibili");
                    }
                    break;
                default:
                    break;
            }

        } while (!azione.equals("esci"));
    }
}
