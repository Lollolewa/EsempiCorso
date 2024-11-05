package org.generation.italy.esempiCorso.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Examples {
    public static void main (String[] args){

//        int[] nums = new int[4];
//        System.out.println(nums[4]);
//        System.out.println("buonasera");
//        non arrivo a stampare buonasera perchè il programma crasha alla riga sopra
        FileInputStream fis = null;
        //gli oggetti che inizializzano nelle tonde devono appartenere a una classe che implementa l'interefaccia Autoclosable
        //se implementi l'interfaccia Autocloable devi fare override il metodo close
        try {
            fis = new FileInputStream("nonEsisto.txt"); //CHECKED
            System.out.println("il file esiste");
            System.out.println(fis.available());

//      } catch (FileNotFoundException e){
//         System.out.println(e.getMessage());
//      } catch(IOException e){
//         throw new RuntimeException(e);
            // se inverto FileNotFound e IOException non funziona perchè FileNotFound è una sottoclasse di IOException
            //se c'è una relazione di ereditarietà tra le eccezioni le più specifiche devono stare prima

        } catch (IOException e){ //polimorfismo
            System.out.println("problema di input output : " + e.getMessage());


        } finally{
            System.out.println("questo può succedere sempre");
//          String s = null;
//          System.out.println(s.length());
//          non bisogna mai inserire un eccezione nel finally (in questo caso nullPointerException)
//          mai mettere return nel finally, altrimenti sovrascrive quello che ritorna la funzione sopra
//          FINO A JAVA 7 ERA NECESSARIO QUESTO:
//            try{
//                if(fis!=null){
//                    fis.close();
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            DA JAVA 8 SI INSERISCE NEL TRY E CATCH
            try(FileInputStream fiss = new FileInputStream("nonEsisto.txt")){

            } catch (IOException e){
                e.printStackTrace();
                System.out.println("problema di input output " + e.getMessage());
            }
        }

        //questa è una rappresentazione poco realistica perchè la main non crasha, sono le funzioni che chiama a crashare
        System.out.println("inizio main");
        function1();
        System.out.println("fine main");
    }
    private static void function1(){
        System.out.println("inizio f1");
        function2();
        System.out.println("fine f1");
    }
    private static void function2(){
        System.out.println("inizio f2");
        //function3();
        System.out.println("fine f2");
    }
    private static void function3() throws FileNotFoundException{
        System.out.println("inizio f3");
        FileInputStream fisss = new FileInputStream("nonEsisto.txt");
        System.out.println("fine f3");
    }
}
