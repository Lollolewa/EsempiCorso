package org.generation.italy.esempiCorso.exceptions;

public class InsufficientFundsException extends Exception {
    private double balance, requestedAmount;
    public InsufficientFundsException(String message, double balance, double requestedAmount ) {
        super(String.format(message, balance, requestedAmount, requestedAmount-balance));
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}
