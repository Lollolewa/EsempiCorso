package org.generation.italy.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class Esercizi01 {
    public static void main(String[] args) {
        int i = 3;
        if (i % 2 != 0) {
            System.out.println("Weird");
        } else if ((i % 2 == 0 && (2 <= i || i <= 20))) {
            System.out.println("Not Weird");
        } else if ((i % 2 == 0 && (6 <= i || i <= 20))) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    int y = 24;
     if (y % 2 != 0) {
        System.out.println("Weird");
    } else if ((y % 2 == 0 && (2 <= y || y <= 20))) {
        System.out.println("Not Weird");
    } else if ((y % 2 == 0 && (6 <= y || y <= 20))) {
        System.out.println("Weird");
    } else {
        System.out.println("Not Weird");
    }
    
       
    }
}
