package org.generation.italy.esempiCorso.gryffindor.esercizioRubrica;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Maria", "Rossa", "123456789");
        System.out.println(rubrica.toString());
        rubrica.rimuoviContatto("Mario", "rosso");
        String numMaria = rubrica.cercaContatto("Maria", "Rossi");
        int lungh;
        if (numMaria != null) {
            lungh = numMaria.length();// nullPointerException
        } else {
            lungh = 0;

            //optional è un wrapper, come una scatola che può avere dentro qualcosa come può non averla
            //il metodo get chiamato su un optional mi restituisce il valore della scatola
            //se la scatola è vuota il get esplode
        }


    }
}
