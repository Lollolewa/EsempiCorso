package org.generation.italy.esempiCorso.bank;

public class Bank {

    private int balance;

    public void deposit(int amount){
        balance += amount;

    }

    public void take(int amount){
        balance = amount > balance ? balance : balance - amount;
    }

    public String toString(){
        return "Saldo: " + balance;
    }


}
