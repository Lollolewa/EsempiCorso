package eserciziEccezioni;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ciao, inserisci un numero intero");
            int a = sc.nextInt();
            System.out.println("Perfetto, ora inserisci il secondo numero, così potrò dividerli!");
            int b = sc.nextInt();
            int result = a / b;
            System.out.println(result);
        }catch (InputMismatchException ime){
            System.out.println("Mi dispiace, hai inserito qualcosa che non è un numero intero");
        }catch (ArithmeticException ae){
            System.out.println("Mi dispiace, non si possono dividere numeri per zero");
        }finally {
            sc.close();
        }
    }
}
