package org.generation.italy.esempiCorso.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Examples {
    public static void main(String[] args) {

//        int[] nums = new int[4];
//        System.out.println(nums[4]);
//        System.out.println("buonasera");

      // gli oggetti che inizializzo nelle tonde devono appartenere a una classa che implementa l interfaccia Autoclosable
//        try(FileInputStream fis = new FileInputStream("nonEsisto.txt");) {
//
//            System.out.println("il file esiste");
//            System.out.println(fis.available());
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("problema di input output " + e.getMessage());
//
//
//        } finally {
//              System.out.println("questo succedera' semppre");
////            try {
////                if (fis != null) {
////                    fis.close();
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
//
     System.out.println("inizio main");
        try {
            function1();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("fine main");

    }

    private static void function1() throws FileNotFoundException {
        System.out.println("inizio f1");
        function2();
        System.out.println("fine f1");
    }

    private static void function2() throws FileNotFoundException {
        System.out.println("inizio f2");
        function3();
        System.out.println("fine f2");
    }

    private static void function3() throws FileNotFoundException {
        System.out.println("inizio f3");

        FileInputStream fis = new FileInputStream("nonEsisto.txt");

        System.out.println("fine f3");
    }
}


















