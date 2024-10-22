package eserciziEccezioni;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        int numReservation = 0;
        try {
            System.out.println("Ciao, inserisci la tua età");
            age = sc.nextInt();
            System.out.println("Ok, ora inserisci il numero di posti che vuoi prenotare");
            numReservation = sc.nextInt();
        }catch (InputMismatchException ime) {
            if (age <= 0) {
                System.out.println("Mi dispiace, hai inserito qualcosa che non è un numero intero positivo.");
            }
        }catch (ArithmeticException ae) {
            if (numReservation > 5) {
                System.out.println("Mi dispiace, hai inserito un numero troppo alto di prenotazioni.");
            }
        }finally {
            sc.close();
            System.out.println("Grazie mille per aver usato il nostro sito per la tua registrazione!");
        }
    }
}
