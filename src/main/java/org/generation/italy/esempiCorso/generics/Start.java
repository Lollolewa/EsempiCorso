package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[]args) {
        //generics sono state aggiunte in seguito
        //classi generics sono al 90% strutture dati
        List names = new ArrayList(); //questa era la sintassi pre java4
        names.add("pippo");
        names.add(Integer.valueOf(4));
        names.add(4); //non passo la primitiva 4, sarà castato a Integer.valueof(4)
        //add vuole una variabile di classe object, non posso passargli una primitiva
        //motivo per cui non si possono inserire le primitive in nessuna struttura dati ad eccezione dell'Array
        //motivo per cui esistono ancora gli Array, posso inserire le primitive e non solo gli oggetti che occupano più memoria
        doSomethingWithList(names);

        List<String> words = new ArrayList<>();
        //ilcompilatore controlla che nella lista inserisco solo stringhe
        words.add("topolino");
        //words.add(Integer.valueOf(2)); non compila perchè non accetta interi
        String y = words.get(0); //non c'è bisogno di castare a stringa perchè il compilatore sa già che non ci tipi diversi da stringa nella lista
        doSomethingWithList(words); //passo una lista generics a un metodo che si aspetta una lista oldSchool
        //List<> e List sono la stessa classe, il simbolo <> è un avvertimento per il compilatore (type erasure)
        //completa compatibilità tra List<> e List
        //la Virtual Machine non sa che esistono List<> ma solo List

        Pair <String, Integer> p1 = new Pair<>("rocket",4);
        Pair <Integer, String> p2 = new Pair<>(4,"rocket");
        System.out.println(p1.equals(p2));
        System.out.println(p1.getFirst());
        System.out.println(p2.getFirst());

    }
    public static void doSomethingWithList(List x){
        x.add("ciccio");
        Object z = x.get(0);
        System.out.println(z);
        String s = (String) x.get(0); //pippo è sempre stato una stringa
        //fare polimorfismo su object è stupido
        //non ha senso avere reference di tipo object perchè non puoi fare niente se non stampare
        //2 soluzioni:
        // 1.sfanculiamo le attuali collection e facciamone una nuova che si focalizzano su un solo tipo in maniera esplicita
        //   le web application sono decennali, mettendo nuove collection non si potrebbero usare su progetti già esistenti ma solo su nuovi
        // 2.aggiungiamo nuove regole al compilatore, in modo che quando creiamo le liste si può specificare il tipo
        x.add(new StringBuilder()); // è una lista normale in cui puoi mettere qualsiasi cosa
    }
    public static void doSomethingWithGenericList(List<String> x){
        x.add("rocket");
        String resunt = x.get(0);
        //x.dd(Integer.valueOf(2));
    }
}
