package sistemaRegistrazioni.esercizio;

import java.util.Scanner;

import java.util.Scanner;

public class RegistrazioneImpl implements Registrazione {
    protected int eta;
    protected int posti;
    protected boolean registrazioneValida;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void inserisciEta() {
        System.out.print("Inserisci la tua età: ");
        try {
            eta = Integer.parseInt(scanner.nextLine());
            if (eta <= 0) {
                System.out.println("Errore: L'età deve essere un numero intero positivo.");
                registrazioneValida = false;
            } else {
                registrazioneValida = true; // Età valida
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore: Inserisci un valore numerico valido per l'età.");
            registrazioneValida = false;
        }
    }

    @Override
    public void inserisciPosti() {
        System.out.print("Inserisci il numero di posti da prenotare (massimo 5): ");
        try {
            posti = Integer.parseInt(scanner.nextLine());
            if (posti <= 0 || posti > 5) {
                System.out.println("Errore: Il numero di posti deve essere un intero positivo e non superiore a 5.");
                registrazioneValida = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Errore: Inserisci un valore numerico valido per il numero di posti.");
            registrazioneValida = false;
        }
    }

    @Override
    public void confermaRegistrazione() {
        if (registrazioneValida) {
            System.out.println("Registrazione completata con successo! Età: " + eta + ", Posti prenotati: " + posti);
        } else {
            System.out.println("Registrazione non completata a causa di errori.");
        }
    }
}
