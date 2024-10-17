package org.generation.italy.esempiCorso.generics;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        // generics sono state aggiunte in seguito//🚀🚀
        // classi generics 90% sono strutture dati
        List names = new ArrayList();
        names.add("pippo");
        names.add(Integer.valueOf(4));
        names.add(4); //Integer.valueOf automaticamente
        doSomethingWithList(names);

        List<String> words = new ArrayList<>();
        words.add("topolino");
        //words.add(Integer.valueOf(2));
        String y = words.get(0);
        doSomethingWithList(words);
        Pair<String,Integer> pair1 = new Pair<>("rocket",3);
        Pair<Integer, String> pair2 = new Pair<>(3,"rocket");
        System.out.println(pair1.equals(pair2));
        System.out.println(pair1.getFirst());
        System.out.println(pair2.getFirst());

        Analyzer<String> analyzer = new Analyzer<>(words);
        String max = analyzer.getMaxElement();
        System.out.println(max);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Analyzer<Integer> analyzerNumbers = new Analyzer<>(numbers);
        int maxNumber = analyzerNumbers.getMaxElement();
        System.out.println(maxNumber);
        analyzerNumbers.sort();
        System.out.println(analyzerNumbers.getElements());

        int[] ns = {1,2,3,4,5};
        MaxMin<Integer> minMax = getMinAndMax(ns);
        System.out.println("Minimo: "+ getMinAndMax().getMin() + ", massimo "+ getMinAndMax()

    }
    public static void doSomethingWithList(List x){
        x.add("ciccio");
        Object z = x.get(0);
        System.out.println(z);
        String s = (String) x.get(0);
        //x.add(new StringBuilder());
    }
    public static void doSomethingWithGenericList(List<String> x){
        x.add("rocket");
        String result = x.get(0);
        //x.add(Integer.valueOf(2));
    }
    public static MaxMin <Integer> getMinAndMax(int[] numbers){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int number : numbers){
            if (number < min){
                min = number;
            }
            if (number > max){
                max = number;
            }
        }
        return new MaxMin<>(min,max);
    }
}
