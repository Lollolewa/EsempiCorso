package org.generation.italy.esempiCorso.exceptions;

public class StartAccount {
    public static void main(String[] args){
        Account account = new Account(1000);
        try{
            account.wirthdraw(500);
            System.out.println("Fatto primo prelievo");
            account.wirthdraw(501);
        }catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
            System.out.println("Balance : " + e.getBalance());
            System.out.println("Request amount: " + e.getRequestedAmount());
        }
    }
}
