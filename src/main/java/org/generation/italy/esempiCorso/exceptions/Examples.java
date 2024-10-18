package org.generation.italy.esempiCorso.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Examples {
    public static void main(String[] args) {
//        int[] nums = new int[4];
//        System.out.println(nums[4]); // errore di runtime
//        System.out.println("buonasera"); // non eseguito, il programma si blocca

        /// se volessi leggere da un file
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("nonEsisto.txt");
            System.out.println("Il file esiste.");
            System.out.println(fis.available()); // vede cosa c'è nel file (quanti byte da leggere)
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}
