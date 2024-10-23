package org.generation.italy.esempiCorso.hufflePuff.eserciziLambda;

import java.util.Arrays;
import java.util.List;

public class Esercizio1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 5, 32, 33, 8, 12, 10, 11);
        List<Integer> numMaxOfTen = nums.stream().filter(n -> n > 10).toList();
        System.out.println(numMaxOfTen);
    }
}
