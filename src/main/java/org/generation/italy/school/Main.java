package org.generation.italy.school;
import org.generation.italy.school.RegistroVoti;


import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Studente studente = new Studente("lucrezia", "lauri");
        RegistroVoti registro = new RegistroVoti();
        Scanner sc = new Scanner(System.in);
        int scelta;

        do{
            System.out.println("Salve, questo e' un registro elettronico! Quale azione vuole effettuare?");
            System.out.println("Opzione 1: aggiungi studente");
            System.out.println("Opzione 2: visualizzare le medie dei voti");
            System.out.println("Opzione 3: registra un voto");
            System.out.println("Opzione 4: uscire");
            scelta = sc.nextInt();
            sc.nextLine();

            switch(scelta){
                case 1:
                    System.out.print("Inserisci il nome dello studente: ");
                    String nome = sc.nextLine();
                    System.out.print("Inserisci il cognome: ");
                    String surname = sc.nextLine();
                    registro.aggiungiStudente(new Studente(nome, surname));
                    break;

                case 2:
                    System.out.print("visualizza le medie dei voti " + "\n");
                    registro.visualizzaMedia();
                    break;

                case 3:
                    System.out.print("Inserisci il nome dello studente per registrare un voto: ");
                    String nomeStudente = sc.nextLine();
                    System.out.print("Inserisci il voto: ");
                    int voto = sc.nextInt();
                    registro.registraVoto(nomeStudente, voto); // Usa l'istanza
                    break;

                case 4:
                    System.out.print("Uscendo..... ");
                    break;

                default:
                    System.out.print("Operazione non valida!!!! ");

            }
        }while(scelta != 4);
        sc.close();
    }

}

/*Crea una classe Main:

Implementa un semplice menu che permette all'utente di:
Aggiungere uno studente.
Registrare un voto.
Visualizzare le medie dei voti.
Uscire dal programma.*/
