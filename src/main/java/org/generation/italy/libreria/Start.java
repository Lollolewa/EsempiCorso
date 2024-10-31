package org.generation.italy.libreria;

import java.util.Scanner;

public class Start {
    public static void main(String[]args){
    Inventario inventario = new Inventario();
    Scanner sc = new Scanner(System.in);
    int scelta;

     do{
        System.out.println("Salve, questa e' una libreria digitale! Quale azione vuole effettuare?");
        System.out.println("Opzione 1: aggiungi libro");
        System.out.println("Opzione 2: visualizzare l'inventario");
        System.out.println("Opzione 3: uscire");
        scelta = sc.nextInt();
        sc.nextLine();

        switch(scelta){
            case 1:
                System.out.print("Inserisci il titolo: ");
                String titolo = sc.nextLine();
                System.out.print("Inserisci l'autore: ");
                String autore = sc.nextLine();
                System.out.print("Inserisci l'anno di pubblicazione: ");
                int anno = sc.nextInt();
                inventario.aggiungiLibro(new Libro (titolo, autore, anno));
                break;

            case 2:
                System.out.print("visualizza l'inventario: " + "\n");
                inventario.visualizzaCollection();
                break;

            case 3:
                System.out.print("Uscendo..... ");
                break;

            default:
                System.out.print("Operazione non valida!!!! ");

        }
     }while(scelta != 3);
        sc.close();
    }
}



/*Crea una classe Main:

Implementa un semplice menu che permette all'utente di:
Aggiungere un libro.
Visualizzare l'inventario.
Uscire dal programma.*/