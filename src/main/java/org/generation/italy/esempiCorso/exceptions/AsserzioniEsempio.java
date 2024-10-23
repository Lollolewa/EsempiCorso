package org.generation.italy.esempiCorso.exceptions;

public class AsserzioniEsempio {
    public static void main(String[] args) {
        int eta = -5;
        // Verifica che l'età sia valida (non può essere negativa)
        assert eta >= 0 : "L'età non può essere negativa!";

        System.out.println("Età valida: " + eta);
    }
}// di default sono disabilitate le asserzioni, per attivare le asserzioni utilizzare il flag -enableassertions/ -ea nella linea di comando
// java -ea AsserzioniEsempio
//

