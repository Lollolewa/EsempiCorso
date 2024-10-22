package org.generation.italy.esempiCorso.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) {
        int numero1 = 10;
        int numero2 = 0;

        try { // create a new exception object.
            int risultato = divide(numero1, numero2);
            System.out.println("Il risultato è: " + risultato);
        } catch (ArithmeticException e) { // Catches l'eccezione ArithmeticException che viene sollevata quando si divide per zero.
            System.out.println("Attenzione: non è possibile dividere per zero.");
        }finally { // Serve per eseguire codice eseguito in ogni caso, indipendentemente dal risultato del try-catch
            System.out.println("Chiusura del programma.");
        }
    }
    private static int divide(int numero1, int numero2) {
        return numero1 / numero2;
    }
}

