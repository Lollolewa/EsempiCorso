package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Topolino");
        words.add("Minnie");
        words.add("Paperino");
        words.add("Bobbyrocketto");

        Analyzer<String> analyzer = new Analyzer<String>(words);
        String max = analyzer.getMax();

        System.out.println(max);

        analyzer.sort();
        System.out.println(analyzer.getElements());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        Analyzer<Integer> analyzerNumbers = new Analyzer<>(numbers);
        int maxNumber = analyzerNumbers.getMax();
        System.out.println(maxNumber);

        analyzerNumbers.sort();
        System.out.println(analyzerNumbers.getElements());

        int[] ns = {1,2,3,4,5};
        MaxMin<Integer> minAndMax = getMinAndMax(ns);
        System.out.println("Minimo: "+minAndMax.getMin()+"\nMassimo: "+minAndMax.getMax());

    }
    public static MaxMin<Integer> getMinAndMax(int[] numbers){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int number : numbers){
            if(number<min){
                 min = number;
            }
            if(number>max){
                max = number;
            }
        }return new MaxMin<>(max,min);
    }
}
