package org.generation.italy.esempiCorso.exceptions;

public class StartAccount {
    public static void main(String[] args) {
        Account account = new Account(1000);
        try {
            account.withdraw(500);
            System.out.println("Operation successfully confirmed!");
            account.withdraw(501);

        } catch (InsufficientFundsException e) {
            System.out.println("Balance: " + e.getBalance());
            System.out.println("Requested amount: " + e.getRequestedAmount());
            System.out.println("Error: " + e.getMessage());

        }
    }
}
