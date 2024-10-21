package org.generation.italy.esempiCorso.exceptions;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public void withdraw (double amount) throws InsufficientFundsException {
        if (balance < amount) {
            // throw new InsufficientFundsException("Insufficient funds");
            throw new InsufficientFundsException("Insufficient funds: Your current balance is " + balance + ", but you requested to withdraw " + amount, balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + ". Remaining balance: " + balance);
    }
    
}
