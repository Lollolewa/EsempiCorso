package org.generation.italy.esempiCorso.collezzioniamo;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args){
        //una collezzione è un insieme di elementi;
        //array è una struttura dati ordinata che contiene primitive, a cui vi si accede tramite indice; Hanno una dimensione fissa;
        String[] nomi = new String[10];
        nomi[0]= "BobbyRocket";
        //interfaccia colletion.java.util contiene metodi di utilità per lavorare sulle collezzioni (apri e cercala con controll+N);
        //al posto di list, avrei potuto usare (guardando la tabella nel file genIta) altri riferimenti (tipo iterable, collection ecc ecc) tuttavia cambiando la reference, cambieranno anche le funzionalità e mi metodi; Anche qui si tratta di polimorfismo;
        List<String> nomiclasse = new ArrayList<>(); // <> li in mezzo a volte potremmo vedere il tipo di variabili dentro l'array
        nomiclasse.add("Bobby");
        nomiclasse.add("Rocket"); //per aggiungere un elemento all'array list usiamo la sintassi .add, come rimuovere .remove;
        nomiclasse.add("Elon");
        //gli array list sono un insieme di elemneti ordinato con una dimensione variabile
        nomiclasse.remove(2);
        System.out.println(nomiclasse);
        String razzo = nomiclasse.get(1); //alla varuabuke razzi vadi ad assicuake l'elemento presente nella posizione indicata fra le parentesi;
        System.out.println(razzo);
        for(int i=0;i<nomiclasse.size(); i++){
            System.out.println(nomiclasse.get(i));
        }
        //sta roba sopra possiamo farla in una maniera più intuitiva e più bella guarda sotto
        //si tratta di un enanched for, dove praticamente andaimo a iniziallizzare una variabile stringa, e per ogni stringa presente nell'array list la stampiamo o ci facciamo quello che vogliamo;
        //al posto di s potevamo mettere ogni nome; e il suo scoop sarà solo all'interno del ciclo; se provassimo a stampare fuori non andrebbe;
        for(String s : nomiclasse){
            System.out.println(s);
        }
        List<String> result = List.of("casa","sexsoffono","chupaca","sEDERE", "sODO","sALVINI");
        System.out.println(result);
        System.out.println(findStartwithS(result));

    }


public static List<String> findStartwithS(List<String> stringhe) {
    List<String> paroleRitorno = new ArrayList<>(); //posso sempre castare dalla superclasse alla classe, ma no viceversa; se in queto caso nella creazione della funziona avessi scritto "ArrayList" mi darebbe errore il ritorno;
    for (String parola : stringhe) {               //stessa cosa nei parametri che gli passo; e ti dirò di più, non essendo che usiamo le funzioni dell'arraylist del parametro, potremmo passare anche una colletio o addiritturas in questo
        if (parola.charAt(0) == 's') {              // in questo caso iterable di string, cosi facendo sfruttiamo il polimorfismo affinchè gli passiamo qualsiasi tipo di iterable;
            paroleRitorno.add(parola);              //in sintesi in questo cosa, se si prova a mettere una di queste superclassi al posto di List, vedrai che funziona e in linea di massima bisogna capire quello che si vuole e rimanere generali è la miglior cosa;
        }
    }
    return paroleRitorno;
}//Ignorant is bliss(cit Matrix)--> Siamo sempre più felici quando lavoriamo con cose generali;

}
