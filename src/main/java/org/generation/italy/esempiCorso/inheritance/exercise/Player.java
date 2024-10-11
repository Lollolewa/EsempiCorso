package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public class Player {
    protected String nome, cognome, nomePersonaggio, password;
    protected LocalDate dataIscrizione;
    protected boolean isLogged;
    Scanner sc = new Scanner(System.in);

    public Player(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged){
        this.nome = nome;
        this.cognome = cognome;
        this.nomePersonaggio = nomePersonaggio;
        this.password = password;
        this.dataIscrizione = dataIscrizione;
        this.isLogged = isLogged;
    }

    public String logIn(String nomePersonaggio, String password){
        System.out.println("inserisci: ");
        nomePersonaggio = sc.nextLine();
        password = sc.nextLine();
        if(nomePersonaggio == this.nomePersonaggio && password == this.password) {
            this.isLogged = true;
            return "LOGIN ESEGUITO";
        }
        this.isLogged = false;
        return "LOGIN NON EFFETTUATO";
    }

    public String logOut(){
        if(this.isLogged){
            this.isLogged = false;
            return "LOGOUT EFFETTUATO";
        }
        return "NON SEI LOGGATO";
    }
}
