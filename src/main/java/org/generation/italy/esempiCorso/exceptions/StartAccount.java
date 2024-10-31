package org.generation.italy.esempiCorso.exceptions;

public class StartAccount {
    public static void main(String[] args) {
        Account account = new Account(1000);
        try{
            account.withdraw(500); //🚀
            System.out.println("Fatto primo prelievo");
            account.withdraw(501);
        }catch(InsufficientFundsException e){
            System.out.println(e.getMessage());
            System.out.println("Balance: " + e.getBalance());
            System.out.println("Requested amount: " + e.getRequestedAmount());
        }
        //account.withdraw(500); non si può fare da sola perché bisogna gestirla con un try catch
    }
}
