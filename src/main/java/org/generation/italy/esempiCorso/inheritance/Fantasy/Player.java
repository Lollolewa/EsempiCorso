package org.generation.italy.esempiCorso.inheritance.Fantasy;
import java.time.LocalDate;

public class Player {
    protected String nome,cognome, nomePersonaggio,password;
    protected LocalDate dataInizio;
    protected boolean isLogged;

    public Player(boolean isLogged, LocalDate dataInizio, String password, String nomePersonaggio, String cognome, String nome) {
        this.isLogged = false;
        this.dataInizio = dataInizio;
        this.password = password;
        this.nomePersonaggio = nomePersonaggio;
        this.cognome = cognome;
        this.nome = nome;
    }
    public void login(String nomePersonaggio, String password){
        if(this.nomePersonaggio.equals(nomePersonaggio) && this.password.equals(password)){
            isLogged = true;
            System.out.println("Login effettuato con successo.");
        } else {
            System.out.println("Nome personaggio o password errati.");
        }
    }
    public void logout(){
        isLogged= false;
        System.out.println("Logout effettuato.");
    }
}