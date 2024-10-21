package org.generation.italy.esempiCorso.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Examples {
    public static void main(String[] args)  {
        int[] nums = new int[4];
        System.out.println(nums[4]);
        System.out.println("buonasera");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("nonEsisto.txt"); // CHECKED (eccezioni che il compilatore ti contringe a controllare)
            System.out.println("il file esiste");                             // solo RunTimeException e le sue figlie sono unchecked
            System.out.println(fis.available());

        } //catch (FileNotFoundException e) {       // figlia di IOException
           // System.out.println(e.getMessage());
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("problema di input output" + e.getMessage());
        } finally { // importante non creare exception o returnare nulla nel finally (si possono creare blocchi try catch nel finally)
            System.out.println("questo succederà sempre");
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // non viene concessa la possibilità di ignorare un'eventuale FileNotFoundException

        // una risorsa inizializzata nel try si chiude automaticamente quando esco dal try
        // posso inizializzare più variabili dentro al try, divise da --> ;
        try(FileInputStream fis1 = new FileInputStream("nonEsisto.txt")) {
            System.out.println("il file esiste");
            System.out.println(fis.available());
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("problema di input output" + e.getMessage());
        } finally {
            System.out.println("questo succederà sempre");
        }

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
        System.out.println("fine f2");
    }
    private static void function2() throws FileNotFoundException {
        System.out.println("inizio f2");
        function3();
        System.out.println("fine f2");
    }
    private static void function3() throws FileNotFoundException {
        System.out.println("inizio f1");

        FileInputStream fis = new FileInputStream("nonEsisto.txt");

        System.out.println("fine f2");
    }
}
