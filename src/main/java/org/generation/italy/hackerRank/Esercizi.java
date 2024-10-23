package org.generation.italy.hackerRank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Esercizi {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        System.out.println("write 3 numbers: ");
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i<3; i++ ){
            numbers.add(scanner.nextInt());
            System.out.println(numbers.get(i));
        }

    }


}

