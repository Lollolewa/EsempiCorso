package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public class Player {
    protected String nome, cognome, nomePersonaggio, password;
    protected LocalDate dataInizio;
    protected boolean isLogged;
    Scanner sc = new Scanner(System.in);
    public Player(String nome, String cognome, String nomePersonaggio, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomePersonaggio = nomePersonaggio;
        this.password = password;
        this.dataInizio = LocalDate.now();
        this.isLogged = false;
    }
    public void login(String nomePersonaggio, String password){
        if(this.nomePersonaggio.equalsIgnoreCase(nomePersonaggio) && this.password.equalsIgnoreCase(password)){
            isLogged = true;
            System.out.println(" Login effettuato con successo: ");
        }
        else {
            System.out.println(" Nome pg o password errati");
        }
    }
    public void logout(){
        isLogged = false;
        System.out.println("Logout effettuato");
    }

}
