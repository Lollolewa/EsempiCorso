package eserciziEccezioni.esercizio1;

import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { //try w/ resources
            System.out.println("Inserire una parola");
            String a = sc.nextLine();
            System.out.println("Bene, ora inserisci la seconda");
            String b = sc.nextLine();

            if (a.isEmpty() || b.isEmpty()) {
                throw new StringaVuotaException("Hai inserito una stringa vuota...");
            }
            int result = a.compareTo(b);

            switch (result) {
                case 0:
                    System.out.println("Le due stringhe sono uguali");
                    break;
                case 1:
                    System.out.println("La prima stringa è la maggiore");
                    break;
                case -1:
                    System.out.println("La seconda stringa è la maggiore");
            }
        } catch (StringaVuotaException sve) {
            System.out.println("Errore " + sve.getMessage());
        }
    }
}
