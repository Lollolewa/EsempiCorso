package org.generation.italy.esempiCorso.exceptions;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public void withdraw (double amount) throws InsufficientFundsException {
        if (balance < amount) {
            //throw new InsufficientFundsException("Insufficient funds");
            throw new InsufficientFundsException("Saldo insufficiente, il saldo corrente è %.2f, l'ammontare richiesto è" +
                    " %.2f, lo sforamento sarebbe di %.2f", balance, amount);
        }
        balance -= amount; //throw è una richiesta di lancio, throws è quando deve lanciare
    }
}
