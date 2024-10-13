package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public class Player {
    protected String nome, cognome, nomePersonaggio, password;
    protected LocalDate dataInizio;
    protected boolean isLogged;
    protected Character character;

    public Player(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataInizio, boolean isLogged) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomePersonaggio = nomePersonaggio;
        this.password = password;
        this.dataInizio = dataInizio;
        this.isLogged = isLogged;
    }
    public boolean login(String nomePersonaggio, String password){
        if(this.nomePersonaggio.equalsIgnoreCase(nomePersonaggio) && this.password.equalsIgnoreCase(password)){
            System.out.println("Login effettuato con successo.");
            isLogged = true;
        }
        else {
            System.out.println("Nome o password errati, riprovare.");
            isLogged = false;
        }
        return isLogged;
    }
    public void logout(){
        isLogged = false;
        System.out.println(nomePersonaggio + ": Logout effettuato.");
    }
    public void setCharacter(Character character) {
        this.character = character;
        System.out.println(character.name + " è stato assegnato a " + nome + " " + cognome);
    }
}
