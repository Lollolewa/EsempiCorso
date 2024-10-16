package org.generation.italy.esempiCorso.collezioniamo.exercises.Rubrica;

import java.util.Optional;

public class Start
{
    /*Sia data una classe Contatto le cui istanze rappresentano contatti telefonici. Ogni contatto ha
    un nome, un cognome e un numero telefonico (tutti di tipo String), un costruttore che riceve come parametro
    il nome, il cognome e il numero di telefono associati al contatto, metodi per leggere tali valori e il metodo
    toString() che restituisce una rappresentazione testuale del contatto.

    Scrivere una classe Rubrica che rappresenta una collezione di contatti. La classe memorizza i contatti per
    mezzo di una lista ed è dotata dei seguenti metodi:
        - void aggiungiContatto(String nome, String cognome, String telefono) che aggiunge un contatto alla
    rubrica;
- void rimuoviContatto(String nome, String cognome) che rimuove dalla rubrica il contatto associato
    al nome e cognome dati;
- String cerca(String nome, String cognome) che dato un nome e cognome restituisce il numero di
    telefono associato a quel nome e cognome oppure null se il nome e cognome non sono presenti in
        rubrica;
- String toString() che restituisce una descrizione testuale dell’intera rubrica*/

    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();

        rubrica.aggiungiContatto("Maria", "Rossa", "1234567899");

        System.out.println(rubrica.toString());

        rubrica.rimuoviContatto("Mario","Rossa");

        Optional<String> optNum = rubrica.cercaContattoOptional("Maria","Rossi");
        // NOOO-> int lungh = optNum.get().length();
        // il metodo get chiamato su un optional mi restituisce il valore della scatola
        // ma se non c'è niente il get esplode, occhio!
        int lungh=0;
        if(optNum.isPresent()) // isPresent, true se c'è, verificate sempre se c'è prima
            lungh = optNum.get().length();

        /* nel caso non utilizzo l'optional:
            int lungh;
            if(numMaria!=null)
                lungh = numMaria.length(); //nullPointerException
            else
                lungh = 0;
        */

        // optional, è un wrapper, come una scatola che può avere dentro qualcosa, come può non averla

    }



}
