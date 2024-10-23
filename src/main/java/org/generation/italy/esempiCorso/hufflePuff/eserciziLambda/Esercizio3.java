package org.generation.italy.esempiCorso.hufflePuff.eserciziLambda;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public class Esercizio3 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,5,3,7,19,11,10,12,40,23);
        int sommaPari = nums.stream()
                            .filter(n -> n % 2 == 0)
                            .mapToInt(n -> n)
                            .sum();
        System.out.println(sommaPari);
    }
}
