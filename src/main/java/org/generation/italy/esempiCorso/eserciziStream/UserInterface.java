package org.generation.italy.esempiCorso.eserciziStream;

import java.util.Scanner;

public class UserInterface {
    private BookRepository repository = new BookRepository();
    Scanner sc = new Scanner(System.in);

    public void begin() {
        System.out.println("""
                Benvenuto in la libreria, seleziona la funzione che vuoi eseguire
                 1.un metodo che ritorna tutti i libri per una data categoria
                 2.un metodo che ritorna tutti i libri che hanno una data parola come parte del loro titolo e sono stati pubblicati entro una dato range di date, ordinati per costo decrescente
                 3.un metodo che restituisce il costo medio per i libri scritti in una data lingua
                 4.un metodo che restituisce tutti i libri scritti da un autore di cui viene dato l'id
                 5.un metodo che restituisca la lista di tutti i libri che hanno piu'di un autore, ordinati per numero di autori decrescente
                 6.un metodo che resituisca la lista di tutti gli autori che hanno mai scritto libri in una data categoria. Gli autori devono essere ordinati per cognome e nome alfabetico e devono apparire nella lista una sola volta.
                Inserisci la tua scelta""");
        int scelta = sc.nextInt();
        switch (scelta) {
            case 1:
                int risposta;
                do {
                    System.out.println(""" 
                            Quale categoria vuoi cercare? 
                            1.ADVENTURE 
                            2.SCIENCE_FICTION 
                            3.NARRATIVE 
                            4.CLASSICS 
                            5.HORROR""");
                    risposta = sc.nextInt();
                    sc.nextLine();

                    // Controlla se l'indice è valido
                    if (risposta >= 0 && scelta < Category.values().length) {
                        Category categoriaSelezionata = Category.values()[scelta];
                        System.out.println("Hai selezionato la categoria: " + categoriaSelezionata);
                        repository.findByCategory(categoriaSelezionata);
                    } else {
                        System.out.println("Scelta non valida. Per favore, inserisci un numero corretto.");
                    }
                } while (risposta > 5);
        }
    }
}
