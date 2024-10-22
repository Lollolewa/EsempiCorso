package org.generation.italy.esempiCorso.altro;

public class BubbleSort {

    // Metodo per eseguire il Bubble Sort su un array
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean scambiato;

        // Ciclo per ciascun elemento dell'array
        for (int i = 0; i < n - 1; i++) {
            scambiato = false;
            System.out.println("Passata " + (i + 1) + ":");

            // Ciclo per confrontare gli elementi adiacenti
            for (int j = 0; j < n - 1 - i; j++) {
                // Stampa gli elementi che stanno per essere confrontati
                System.out.println("  Confronto: " + array[j] + " e " + array[j + 1]);

                // Se l'elemento corrente è maggiore del successivo, scambiali
                if (array[j] > array[j + 1]) {
                    System.out.println("  -> Scambio: " + array[j] + " con " + array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    scambiato = true; // Segnala che c'è stato uno scambio
                }
            }

            // Stampa l'array dopo ogni passata
            System.out.print("Array dopo la passata " + (i + 1) + ": ");
            stampaArray(array);

            // Se nessun elemento è stato scambiato, l'array è già ordinato
            if (!scambiato) {
                System.out.println("Nessuno scambio effettuato, l'array è già ordinato.");
                break;
            }
        }
    }

    // Metodo per stampare l'array
    public static void stampaArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    // Metodo principale per testare il Bubble Sort
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2, 8};

        System.out.println("Array originale:");
        stampaArray(array);

        // Ordina l'array usando il Bubble Sort
        bubbleSort(array);

        System.out.println("Array ordinato finale:");
        stampaArray(array);
    }
}


