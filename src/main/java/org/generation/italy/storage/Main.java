package org.generation.italy.storage;

import org.generation.italy.school.RegistroVoti;
import org.generation.italy.school.Studente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Prodotto prodotto = new Prodotto("Pasta", 1.50, 5);
        Magazzino magazzino = new Magazzino();
        Scanner sc = new Scanner(System.in);
        int scelta = 0;

        do{
            System.out.println("Salve, questo e' un magazzino digitale! Quale azione vuole effettuare?");
            System.out.println("Opzione 1: aggiungi prodotto");
            System.out.println("Opzione 2: visualizza tutti i prodotti");
            System.out.println("Opzione 3: cerca prodotti per nome  ");
            System.out.println("Opzione 4: uscire");
            try {
                scelta = sc.nextInt();
                sc.nextLine();

                switch (scelta) {
                    case 1:
                        System.out.print("Inserisci il nome del prodotto: ");
                        String name = sc.nextLine();
                        System.out.print("Inserisci il prezzo : ");
                        double price = sc.nextDouble();
                        System.out.print("Inserisci la quantità : ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        magazzino.aggiungiProdotto(new Prodotto(name, price, quantity));
                        break;

                    case 2:
                        System.out.print("visualizza prodotti " + "\n");
                        magazzino.visualizzaProdotti();
                        break;

                    case 3:
                        System.out.print("cerca un prodotto per nome " + "\n");
                        String nomeProdotto = sc.nextLine();
                        Prodotto prodottoTrovato = magazzino.cercaProdotto(nomeProdotto);
                        if (prodottoTrovato != null) {
                            System.out.println(prodottoTrovato);
                        } else {
                            System.out.println("Prodotto non trovato.");
                        }
                        break;

                    case 4:
                        System.out.print("Uscendo..... ");
                        break;

                    default:
                        System.out.print("Operazione non valida!!!! ");

                }
            }catch (InputMismatchException e){
            System.out.println("Errore: inserisci un valore valido.");
            sc.nextLine();
            }
        }while(scelta != 4);
        sc.close();
    }
}
/*
Aggiungere un prodotto.
Visualizzare tutti i prodotti.
Cercare un prodotto per nome.
Uscire.*/
