package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {


    //le generics non sono sempre esistite
    // avere delle classi che si speciallizano a lavorare con altri classi
    // 90% sono usate su strutture dati

        List names = new ArrayList(); //i dati primitivi non sono Object ma primitive date
        names.add("Pippo");
        names.add(Integer.valueOf(4)); //passare un numero intero
         names.add(4);
         doSomethingWhithList(names);


         List<String> words = new ArrayList<>();
         words.add("topolino");
         //words.add(Integer.valueOf(5)); non si puo fare
        String y = words.get(0);

        doSomethingGenericList(words);
        Pair<String, Integer> p1 = new Pair<>("Ciao",5);
        Pair <Integer,String> p2 = new Pair<>(3,"Ciao");
        System.out.println(p1.equals(p2));
        System.out.println(p1.getFirst());
        System.out.println(p2.getFirst());



}

public static void doSomethingWhithList(List x){
        x.add("ciccio");
        Object z = x.get(0);
    System.out.println(z);
    String s = (String) x.get(0);
}
public static void doSomethingGenericList(List<String> x){
        x.add("Pippo");
        String result = x.get(0);
    System.out.println(result);
}

}