package org.generation.italy.esempiCorso.bank;

import java.util.Locale;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Bank bank = new Bank();
        String azione = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Vuoi prelevare, depositare o vedere il saldo?");
            azione = sc.nextLine();

            switch (azione.toLowerCase(Locale.ROOT)) {
                case "depositare":
                    System.out.println("Quanto vuoi depositare?");
                    int deposito = Integer.parseInt(sc.nextLine());
                    bank.deposit(deposito);
                    System.out.println(bank.toString());
                    break;
                case "prelevare":
                    System.out.println("Quanto vuoi prelevare?");
                    int prelievo = Integer.parseInt(sc.nextLine());
                    bank.take(prelievo);
                    System.out.println(bank.toString());
                    break;
                case "saldo":
                    System.out.println(bank.toString());
                    break;
                case "esci":
                    System.out.println("Ciao ciao");
                    break;
                default:
                    break;
            }

        } while (!azione.equals("esci"));

    }
}
