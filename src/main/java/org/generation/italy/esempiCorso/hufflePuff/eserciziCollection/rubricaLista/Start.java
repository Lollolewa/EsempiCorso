package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.rubricaLista;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {

        ArrayList<Contatto> listaContatti = new ArrayList<>();


        Rubrica rubrica = new Rubrica(listaContatti);


        rubrica.aggiungiContatto("Mario", "Rossi", "123456789");
        rubrica.aggiungiContatto("Luca", "Bianchi", "987654321");
        rubrica.aggiungiContatto("Anna", "Verdi", "112233445");


        System.out.println(rubrica);

        String numeroTrovato = rubrica.cerca("Luca", "Bianchi");
        if (numeroTrovato != null) {
            System.out.println("Numero trovato: " + numeroTrovato);
        } else {
            System.out.println("Contatto non trovato.");
        }


        rubrica.rimuoviContatto("Mario", "Rossi");


        System.out.println("Rubrica dopo rimozione di Mario Rossi:");
        System.out.println(rubrica);
    }
}