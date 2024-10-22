package org.generation.italy.esempiCorso.generic;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main (String[] arg) {
        //Le generic sono state aggiunte sucessivamente e non sono native di java, e al 90% possiamo dire che sono strutture di dati.
        List names = new ArrayList(); //una volta si faceva in questa maniera; Sfruttando il polimorfismo istanziamo names con una reference di classe oggetto per includere ogni cosa;
        //quindi in questo caso prima si faceva cosi;
        names.add("ciao");
        names.add(Integer.valueOf(4)); //il problema qui è appunto che non posso andare ad aggiungere primitive, ma posso prendere solo oggetti!
        //l'unica struttura dati che accetta primitive sono gli array;
        names.add(4); //se faccio cosi fa la stessa cosa che fa sopra, semplicemnte Integer.valueOf viene fatto automaticamente;
        //facendo cosi avremmo problemi con le funzioni! guarda sotto:
        doSomethingWithThisList(names);
        List<String> namesList = new ArrayList<>();
        namesList.add("cocomero");
        //names.add(Integer.valueOf(7)); questa sintassi infatti ora è sbagliato perchè è il compilatore, una volta definito il tipo di lista che abbiamo, a verificare che ongi elemento che aggiungiamo dev'essere per forza una Stringa!
        String x = namesList.get(0); // ora a differenza della funzione sotto, non serve più fare il casting forzato perchè per forza di cose nella nostra lista ci saranno stringhe!
        //in java avviene il type eraser, quindi la virtual machine non vede i tipi delle varie variabili;
        AnalYzer<Integer> numbers = new AnalYzer<>(new ArrayList<>(),4 );
        numbers.add(3345);
        numbers.add(34);
        numbers.add(245);
        numbers.sort();
        System.out.println(numbers.getElements() + "ecco i numeri"); //ecco come si usano!
    }
    public static void doSomethingWithThisList(List x){
        x.add("cicco"); //qui ancora non abbiamo problemi, i problemi sorgono l'addove voglio andare prendere un oggetto della lista e assegnarlo ad una reference, non sapendone il tipo dovrò usare sempre object some reference;
        Object z=x.get(0); //ovviamente ciò è problematico perchè facendo cosi vedremo solo le reference di object;
        System.out.println(z); //cosi riusciamo a stampare z, ma è molto scomodo;
        String s= (String) x.get(0); // usiamo un casting forzato così per voler andare a definire un valore di tipo object della nostra lista e l'assegnamo ad una variabile di tipo String;
        //il polimorfismo usando object era estramente scomdo per tutte queste cose! Soprattuto perchè java opera nelle "enterprise application", cioè applicazioni molto grandi e complesse!
        //invece di andare a modificare tutti i package ciò che i creatori di java hanno fatto è stato cambiare le regole al compilatore;
        //torna sopra per vedere come fa ora!
    }
    public static void doSomethingWithThisGenericList(List<String> x) {
        x.add("Rocket");
        String result = x.get(0);
        //x.add(Integer.valueOf(2)); stessa cosa per sopra, il compilatore verifica se il tipo che vogliamo andare ad inserire corrispondono al tipo della nostra lista!
    }
}

